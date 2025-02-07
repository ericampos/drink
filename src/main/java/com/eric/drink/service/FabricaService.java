package com.eric.drink.service;

import com.eric.drink.models.PedidoFabrica;
import com.eric.drink.repository.PedidoClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.eric.drink.models.PedidoCliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FabricaService {

    private final RabbitTemplate rabbitTemplate;
    private final PedidoClienteRepository repository;

    @Scheduled(fixedRate = 60000) // A cada minuto
    @Transactional
    public void processarPedidosPendentes() {

        repository.findAllByProcessadoFalse().stream()
                .collect(Collectors.groupingBy(PedidoCliente::getCnpj))
                .forEach((revenda, pedidos) -> {
                    int total = pedidos.stream()
                            .flatMap(p -> p.getItens().values().stream())
                            .mapToInt(Integer::intValue)
                            .sum();

                    if (total >= 1000) {
                        Map<String, Integer> itensConsolidados = consolidarItens(pedidos);
                        rabbitTemplate.convertAndSend("pedidos-fabrica", new PedidoFabrica(revenda, itensConsolidados));
                        pedidos.forEach(p -> p. setProcessado(true));
                        repository.saveAll(pedidos);
                    }
                });
    }

    private Map<String, Integer> consolidarItens(List<PedidoCliente> pedidos) {

        Map<String, Integer> consolidado = new HashMap<>();

        for (PedidoCliente pedido : pedidos) {

            Map<String, Integer> itens = pedido.getItens();

            itens.forEach((chave, valor) -> {
                consolidado.merge(chave, valor, Integer::sum);
            });
            }

        return consolidado;
    }
}

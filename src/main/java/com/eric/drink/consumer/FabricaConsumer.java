package com.eric.drink.consumer;

import com.eric.drink.models.PedidoFabrica;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FabricaConsumer {
    private final RestTemplate restTemplate;

    @RabbitListener(queues = "pedidos-fabrica")
    public void processarPedido(PedidoFabrica pedido) {
        ResponseEntity<Void> response = restTemplate.postForEntity("http://fabrica-mock/api/pedidos", pedido, Void.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Falha ao enviar pedido");
        }
    }
}

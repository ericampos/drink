package com.eric.drink.controller;

import com.eric.drink.dto.PedidoRequest;
import com.eric.drink.dto.PedidoResponse;
import com.eric.drink.models.PedidoCliente;
import com.eric.drink.service.PedidoClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoClienteService service;

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@Valid @RequestBody PedidoRequest request) {
        PedidoCliente pedido = service.criarPedido(request);
        return ResponseEntity.ok(new PedidoResponse(pedido.getId(), pedido.getItens()));
    }
}

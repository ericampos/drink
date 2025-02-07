package com.eric.drink.controller;

import com.eric.drink.models.PedidoCliente;
import com.eric.drink.repository.PedidoClienteRepository;
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
    private final PedidoClienteRepository repository;

    @PostMapping
    public ResponseEntity<PedidoCliente> criar(@Valid @RequestBody PedidoCliente request) {

        return ResponseEntity.ok(repository.save(request));
    }
}

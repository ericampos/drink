package com.eric.drink.repository;

import com.eric.drink.models.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.UUID;

public interface PedidoClienteRepository extends JpaRepository<PedidoCliente, UUID> {
    Arrays findAllByProcessadoFalse();
}

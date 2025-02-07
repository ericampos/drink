package com.eric.drink.repository;

import com.eric.drink.models.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoClienteRepository extends JpaRepository<PedidoCliente, UUID> {

    @Query("SELECT p FROM PedidoCliente p JOIN FETCH p.itens WHERE p.processado = false")
    List<PedidoCliente> findAllByProcessadoFalse();
}

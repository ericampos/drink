package com.eric.drink.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PedidoCliente {
    @Id
    @GeneratedValue
    private UUID id;

    private String clienteId;

    @ManyToOne
    private Revenda revenda;

    @ElementCollection
    private Map<String, Integer> itens; // produto -> quantidade

    private boolean processado = false;

}
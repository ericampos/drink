package com.eric.drink.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Entity
@Getter
@Setter
public class PedidoFabrica {

    @Id
    @GeneratedValue
    private int numeroPedido;

    private String clienteId;

    @ManyToOne
    private Revenda revenda;

    @ElementCollection
    private Map<String, Integer> itens; // produto -> quantidade
}

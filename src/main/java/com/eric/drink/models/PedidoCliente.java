package com.eric.drink.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoCliente {
    @Id
    @GeneratedValue
    private UUID id;

    private String clienteId;

    private String cnpj;

    @ElementCollection
    private Map<String, Integer> itens; // produto -> quantidade

    private boolean processado = false;
}
package com.eric.drink.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PedidoFabrica implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    private String Cnpj;

    @ElementCollection
    private Map<String, Integer> itens; // produto -> quantidade

    public PedidoFabrica(String cnpj, Map<String, Integer> itensConsolidados) {
    }
}

package com.eric.drink.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PedidoResponse {

    @Id
    @GeneratedValue
    private UUID id;

    @ElementCollection
    private Map<String, Integer> itens; // produto -> quantidade
}

package com.eric.drink.dto;

import com.eric.drink.models.Revenda;

public class PedidoRequest {

    String cliente;
    String cnpjRevenda;
    ItensPedido itensPedido;
}

class ItensPedido {
    String item;
    int quantidade;
}

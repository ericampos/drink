package com.eric.drink.dto;

public class PedidoRequest {

    String cliente;
    String cnpjRevenda;
    ItensPedido itensPedido;
}

class ItensPedido {
    String item;
    int quantidade;
}

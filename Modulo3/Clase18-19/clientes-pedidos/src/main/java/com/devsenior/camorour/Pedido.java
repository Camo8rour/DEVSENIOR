package com.devsenior.camorour;

public class Pedido {
    private String clienteId;
    private String producto;
    private Integer cantidad;

    public Pedido(String clienteId, String producto, Integer cantidad) {
        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return String.format("{clienteId: %s, producto: %s, cantidad: %s}", clienteId, producto, cantidad);
    }
}

package com.devsenior.camorour;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GestionPedidos {

    private static final Logger LOG = LoggerFactory.getLogger(GestionPedidos.class);

    private List<Pedido> pedidos;
    private GestionClientes clientes;

    public GestionPedidos(GestionClientes clientes) {
        LOG.debug("Creando la instancia de gestion de pedidos.");
        this.clientes = clientes;
        pedidos = new ArrayList<Pedido>();
    }

    public void crearPedido(String clienteId, String producto, int cantidad) throws PedidoInvalidoException {
        LOG.trace("Llamando a crear pedido.");
        LOG.debug("Los parametros son: {} {} {}", clienteId, producto, cantidad);
        // Cliente no existe.
        try {
            var cliente = clientes.buscarClientes(clienteId);
            LOG.debug("El cliente del pedido es: {}", cliente);
        } catch (ClienteNoEncontradoExcepcion e) {
            LOG.warn("El cliente no existe: {}", clienteId);
            throw new PedidoInvalidoException("El cliente no existe");
        }

        // Producto es vacio.
        if (producto.isEmpty()) {
            LOG.warn("El producto esta vacio.");
            throw new PedidoInvalidoException("El producto no puede estar vacio.");
        }

        // Cantidad es <= 0.
        if (cantidad <= 0) {
            LOG.warn("La cantidad es menor o igual a 0.");
            throw new PedidoInvalidoException("La cantidad debe ser mayor a 0.");
        }

        var pedido = new Pedido(clienteId, producto, cantidad);
        LOG.warn("Agregando el pedido {}", pedido);
        pedidos.add(pedido);
        LOG.info("Se creo el pedido.");
    }

    public Pedido buscarPedido(String clienteId, String producto) {
        LOG.trace("Ingreso a buscar un pedido.");
        LOG.debug("Ingresa con los datos {} {}", clienteId, producto);

        var cliente = clientes.buscarClientes(clienteId);

        for (var pedido : pedidos) {
            if (pedido.getClienteId().equals(clienteId) && pedido.getProducto().equals(producto)) {
                return pedido;
            }
        }

        LOG.warn("El pedido no fue encontrado!");
        return null;
    }
}

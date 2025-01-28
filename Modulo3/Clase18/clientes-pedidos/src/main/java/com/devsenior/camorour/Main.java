package com.devsenior.camorour;

import org.apache.logging.log4j.LogManager;

public class Main {
    public static void main(String[] args) {
        var log = LogManager.getLogger(Main.class);

        log.info("Iniciando el programa.");
        var clientes = new GestionClientes();
        log.debug("Registrando el cliente (1, Pepito)");
        clientes.registrarClientes("1", "Pepito");
        log.info("Se registro el cliente 'Pepito' con id '1'");

        log.debug("Registrando el cliente (3, Luisa)");
        clientes.registrarClientes("3", "Luisa");
        log.info("Se registro el cliente 'Luisa' con id '3'");

        log.debug("Registrando el cliente (5, Maria)");
        clientes.registrarClientes("5", "Maria");
        log.info("Se registro el cliente 'Maria' con id '5'");

        var pedidos = new GestionPedidos(clientes);
        try {
            log.debug("Creando el pedido (1, Laptop, 10)");
            pedidos.crearPedido("1", "Laptop", 10);
            log.info("Se creo el pedido (1, Laptop, 10)");

            log.debug("Creando el pedido (3, Mouse, 3).");
            pedidos.crearPedido("3", "Mouse", 3);
            log.info("Se creo el pedido (3, Mouse, 3)");

            log.debug("Creando el pedido (5, Teclado, 8)");
            pedidos.crearPedido("5", "Teclado", 8);
            log.info("Se creo el pedido (5, Teclado, 8)");

        } catch (PedidoInvalidoException e) {
            log.warn("No se pudo crear uno de los pedidos.", e);
            System.err.println("Ha ocurrido un error al gestionar el pedido.\n" + e.getMessage());
        }

        System.out.println("Gracias por nuestro servicio.");
        log.info("Terminando el programa.");
    }
}
package com.devsenior.camorour;

import org.apache.logging.log4j.LogManager;

public class Main {
    public static void main(String[] args) {
        var log = LogManager.getLogger(Main.class);

        log.info("Iniciando el programa.");
        var productos = new Inventario();

        log.debug("Agregando el producto (Mesa, 4)");
        productos.agregarProducto("Mesa", 4);
        log.info("Se agrego el producto 'Mesa' y con cantidad '4'");

        log.debug("Agregando el producto (Silla, 8)");
        productos.agregarProducto("Silla", 8);
        log.info("Se agrego el producto 'Silla' y con cantidad '8'");

        log.debug("Agregando el producto (Puerta, 12)");
        productos.agregarProducto("Puerta", 12);
        log.info("Se agrego el producto 'Puerta' con cantidad '12'");

        try {
            log.debug("Actualizando el producto (Mesa, 10)");
            productos.actualizarCantidad("Mesa", 10);
            log.info("Se actualizo el producto (Mesa, 10)");

        } catch (CantidadInvalidaException e) {
            log.warn("No se pudo actualizar el producto.", e);
            System.err.println("Ha ocurrido un error al actualizar el producto.\n" + e.getMessage());
        }

        try {
            log.debug("Buscando el producto (Mesa)");
            productos.buscarProducto("Mesa");
            log.info("Se encontro el producto (Mesa)");
        } catch (ProductoNoEncontradoException e) {
            log.warn("No se pudo encontar el producto.", e);
            System.err.println("Ha ocurrido un error al buscar el producto.\n" + e.getMessage());
        }

        try {
            log.debug("Eliminando el producto (Silla)");
            productos.eliminarProducto("Silla");
            log.info("Se elimino el producto (Silla)");
        } catch (ProductoNoEncontradoException e) {
            log.warn("No se pudo eliminar el producto.", e);
            System.err.println("Ha ocurrido un error al eliminar el producto.\n" + e.getMessage());
        }

        System.out.println("Gracias por usar el invantario.");
        log.info("Terminando el programa.");

    }
}
package com.devsenior.camorour;

import org.apache.logging.log4j.LogManager;

public class Main {
    public static void main(String[] args) {
        var log = LogManager.getLogger(Main.class);

        log.info("Iniciando el programa.");
        var clientes = new GestionClientes();
        var reservas = new GestionReservas(clientes);
        
        log.debug("Registrando el cliente (1, Pedro)");
        clientes.registrarCliente("1", "Pedro");
        log.info("Se registro el cliente 'Pedro' con id '1'");

        log.debug("Registrando el cliente (2, Juanita)");
        clientes.registrarCliente("2", "Juanita");
        log.info("Se registro el cliente 'Juanita' con id '2'");

        log.debug("Registrando el cliente (3, Roberto)");
        clientes.registrarCliente("3", "Roberto");
        log.info("Se registro el cliente 'Roberto' con id '3'");

        try {
            log.debug("Creando la reserva (1, 2025-02-01, 2025-02-02).");
            reservas.crearReserva("1", "2025-02-01", "2025-02-02");
            log.info("Se creo la reserva (1, 2025-02-01, 2025-02-02)");

            log.debug("Creando la reserva (2, 2025-03-05, 2025-03-10).");
            reservas.crearReserva("2", "2025-03-05", "2025-03-10");
            log.info("Se creo la reserva (2, 2025-03-05, 2025-03-10)");

            log.debug("Creando la reserva (3, 2025-01-30, 2025-01-31).");
            reservas.crearReserva("3", "2025-01-30", "2025-01-31");
            log.info("Se creo la reserva (3, 2025-01-30, 2025-01-31)");

        } catch (ReservaInvalidaException e) {
            log.warn("No se pudo crear una de las reservas.", e);
            System.err.println("Ha ocurrido un error al gestionar la reserva.\n" + e.getMessage());
        }

        try {
            log.debug("Buscando el cliente (2)");
            clientes.buscarCliente("2");
            log.info("Se encontro el cliente (2)");
        } catch (ClienteNoEncontradoException e) {
            log.warn("No se pudo encontar el cliente.", e);
            System.err.println("Ha ocurrido un error al buscar el cliente.\n" + e.getMessage());
        }

        try {
            log.debug("Buscando la reserva (2, 2025-03-05).");
            reservas.buscarReserva("2", "2025-03-05");
            log.info("Se encontro la reserva (2, 2025-03-05).");
        } catch (ClienteNoEncontradoException e) {
            log.warn("No se pudo encontar la reserva.", e);
            System.err.println("Ha ocurrido un error al buscar la reserva.\n" + e.getMessage());
        }

        System.out.println("Gracias por utilizar el programa.");
        log.info("Terminando el programa.");
    }
}
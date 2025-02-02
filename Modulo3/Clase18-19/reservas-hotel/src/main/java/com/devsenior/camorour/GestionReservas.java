package com.devsenior.camorour;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GestionReservas {

    private static final Logger LOG = LoggerFactory.getLogger(GestionReservas.class);

    private List<Reserva> reservas;
    private GestionClientes clientes;

    public GestionReservas(GestionClientes clientes) {
        LOG.debug("Creando la instancia de gestion de reservas.");
        this.clientes = clientes;
        reservas = new ArrayList<Reserva>();
    }

    public void crearReserva(String clienteId, String fechaInicio, String fechaFin) throws ReservaInvalidaException {
        LOG.trace("Llamando a crear reserva.");
        LOG.debug("Los parametros son: {} {} {}", clienteId, fechaInicio, fechaFin);
        // Cliente no existe.
        try {
            var cliente = clientes.buscarCliente(clienteId);
            LOG.debug("El cliente de la reserva es: {}", cliente);
        } catch (ClienteNoEncontradoException e) {
            LOG.warn("El cliente no existe: {}", clienteId);
            throw new ReservaInvalidaException("El cliente no existe");
        }

        // Fechas estan vacias.
        if (fechaInicio.isEmpty() || fechaFin.isEmpty()) {
            LOG.warn("Una de las fechas esta vacia.");
            throw new ReservaInvalidaException("Las fechas no pueden estar vacias.");
        }

        // Fechas invalidas.
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaInicioDate = LocalDate.parse(fechaInicio, formatter);
            LocalDate fechaFinDate = LocalDate.parse(fechaFin, formatter);

            if (fechaInicioDate.isAfter(fechaFinDate)) {
                LOG.warn("La fecha de inicio es posterior a la fecha de fin.");
                throw new ReservaInvalidaException("La fecha de inicio no puede ser posterior a la fecha de fin.");
            }

            if (fechaInicioDate.isBefore(LocalDate.now())) {
                LOG.warn("La fecha de inicio es en el pasado.");
                throw new ReservaInvalidaException("La fecha de inicio no puede ser en el pasado.");
            }

        } catch (DateTimeParseException e) {
            LOG.warn("Las fechas no tienen un formato válido.");
            throw new ReservaInvalidaException("El formato de las fechas no es válido. Debe ser yyyy-MM-dd.");
        }

        var reserva = new Reserva(clienteId, fechaInicio, fechaFin);
        LOG.warn("Agregando la reserva {}", reserva);
        reservas.add(reserva);
        LOG.info("Se creo la reserva.");
    }

    public Reserva buscarReserva(String clienteId, String fechaInicio) {
        LOG.trace("Ingreso a buscar un pedido.");
        LOG.debug("Ingresa con los datos {} {}", clienteId, fechaInicio);

        for (var reserva : reservas) {
            if (reserva.getClienteId().equals(clienteId) && reserva.getFechaInicio().equals(fechaInicio)) {
                return reserva;
            }
        }

        LOG.warn("La reserva no fue encontrada, ya que el cliente no existe!");
        throw new ClienteNoEncontradoException("El cliente no existe.");
    }
}

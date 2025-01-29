package com.devsenior.camorour;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GestionClientes {

    private static final Logger LOG = LoggerFactory.getLogger(GestionClientes.class);

    private List<Cliente> clientes;

    public GestionClientes() {
        LOG.debug("Creando la instancia de gestion de clientes.");
        clientes = new ArrayList<>();
    }

    public void registrarCliente(String id, String nombre){
        LOG.trace("Llamando a registar clientes.");
        LOG.debug("Los parametros son: {} {}", id, nombre);

        var cliente = new Cliente(id, nombre);
        LOG.warn("Agregando el cliente {}", cliente);
        clientes.add(cliente);
        LOG.info("Se se registro el cliente.");
    }

    public Cliente buscarCliente(String id){
        LOG.trace("Ingreso a buscar un cliente.");
        LOG.debug("Ingresa con los datos {}", id);

        for (var cliente : clientes) {
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }
        LOG.warn("El cliente no fue encontrado.");
        throw new ClienteNoEncontradoException("El cliente con el id " + id + " no fue encontrado.");
    }

}

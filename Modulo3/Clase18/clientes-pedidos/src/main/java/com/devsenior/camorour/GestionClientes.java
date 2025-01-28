package com.devsenior.camorour;

import java.util.ArrayList;
import java.util.List;

public class GestionClientes {

    private List<Cliente> clientes;

    public GestionClientes() {
        clientes = new ArrayList<>();
    }

    public void registrarClientes(String id, String nombre){
        var cliente = new Cliente(id, nombre);
        clientes.add(cliente);
    }

    public Cliente buscarClientes(String id){

        for (var cliente : clientes) {
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }

        throw new ClienteNoEncontradoExcepcion("El cliente con el id " + id + "no fue encontrado.");
    }
}

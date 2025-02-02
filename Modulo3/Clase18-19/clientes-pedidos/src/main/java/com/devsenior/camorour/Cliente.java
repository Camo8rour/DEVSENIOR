package com.devsenior.camorour;

public class Cliente {
    private String id;
    private String nombre;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, nombre: %s}", id, nombre);
    }

}

package com.devsenior.camorour;

public class ClienteNoEncontradoExcepcion extends RuntimeException {
    
    public ClienteNoEncontradoExcepcion(String message) {
        super(message);
    }
}

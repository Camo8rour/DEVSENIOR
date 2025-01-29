package com.devsenior.camorour;

public class Reserva {
    private String clienteId;
    private String fechaInicio;
    private String fechaFin;
    
    public Reserva(String clienteId, String fechaInicio, String fechaFin) {
        this.clienteId = clienteId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    @Override
    public String toString() {
        return String.format("{clienteId: %s, fechaInicio: %s, fechaFin: %s}", clienteId, fechaInicio, fechaFin); 
    }

}

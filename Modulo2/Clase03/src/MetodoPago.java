public interface MetodoPago {

    void procesarPago(double monto); //Metodo abtracto

    String obtenerDetalles(); //Metodo abtracto
    
    boolean validarMonto(double monto); //Metodo abtracto

}

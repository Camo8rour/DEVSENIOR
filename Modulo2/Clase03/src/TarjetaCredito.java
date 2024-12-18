public class TarjetaCredito implements MetodoPago{

    //monto mayor > 0;
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago procesado con tarjeta de crédito por un monto de $" + monto + ".");
    }

    @Override
    public String obtenerDetalles() {
            return "Se realizo el pago con la targeta de crédito";
    }

    @Override
    public boolean validarMonto(double monto) {
            return monto > 0;
    }

}

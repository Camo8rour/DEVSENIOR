public class TarjetaCredito implements MetodoPago{

    //monto mayor > 0;
    @Override
    public void procesarPago(double monto) {
        System.out.printf("%nPago procesado con tarjeta de crédito por un monto de $%s.", monto);
    }

    @Override
    public String obtenerDetalles() {
            return "Se realizó el pago con la targeta de crédito";
    }

    @Override
    public boolean validarMonto(double monto) {
            return monto > 0;
    }

}

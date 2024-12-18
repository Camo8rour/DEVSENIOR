public class PayPal implements MetodoPago{

    //monto entre => 1 && <= 10000;
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago procesado a traves de PayPal por un monto de $" + monto + ".");
    }

    @Override
    public String obtenerDetalles() {
        return "Se realizo el pago con PayPal";
    }

    @Override
    public boolean validarMonto(double monto) {
        return monto >= 1 && monto <= 10000;
    }

}

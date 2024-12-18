public class Bitcoin implements MetodoPago{

    //monto mayor o igual => 0.001 BTC;
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago procesado con Bitcoin por un monto de " + monto + " BTC.");
    }

    @Override
    public String obtenerDetalles() {
        return "Se realizo el pago con Bitcoin";
    }

    @Override
    public boolean validarMonto(double monto) {
        return monto >= 0.001;
    }

}

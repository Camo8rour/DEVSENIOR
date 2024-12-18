public class Bitcoin implements MetodoPago{

    //monto mayor o igual => 0.001 BTC;
    @Override
    public void procesarPago(double monto) {
        System.out.printf("%nPago procesado con Bitcoin por un monto de %s BTC.", monto);
    }

    @Override
    public String obtenerDetalles() {
        return "Se realizó el pago con Bitcoin";
    }

    @Override
    public boolean validarMonto(double monto) {
        return monto >= 0.001;
    }

}

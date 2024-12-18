public class TarjetaRegalo implements MetodoPago{

    //monto mayor > 0 && <= 500; y menor o igual
    @Override
    public void procesarPago(double monto) {
        System.out.printf("%nPago procesado con tarjeta de regalo por un monto de $%s.", monto);
    }

    @Override
    public String obtenerDetalles() {
        return "Se realizó el pago con tarjeta de regalo";
    }

    @Override
    public boolean validarMonto(double monto) {
        return monto > 0 && monto <= 500;
    }

}

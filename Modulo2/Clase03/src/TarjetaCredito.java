public class TarjetaCredito implements MetodoPago{

    //monto mayor > 0;
    @Override
    public void procesarPago(double monto) {
        monto = 0;
        System.out.println("Monto total: " + monto);
    }

    @Override
    public String obtenerDetalles() {
            return null;
    }

    @Override
    public boolean validarMonto(double monto) {
            return false;
    }

}

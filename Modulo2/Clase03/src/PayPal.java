public class PayPal implements MetodoPago{

    //monto entre => 1 && <= 10000;
    @Override
    public void procesarPago(double monto) {
        monto = 10;
        System.out.println("Monto total: " + monto);
    }

    @Override
    public String obtenerDetalles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDetalles'");
    }

    @Override
    public boolean validarMonto(double monto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarMonto'");
    }

}

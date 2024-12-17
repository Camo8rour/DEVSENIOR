public class TransferenciaBancaria implements MetodoPago{

    //monto mayor o igual => 10;
    @Override
    public void procesarPago(double monto) {
        monto = 20;
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

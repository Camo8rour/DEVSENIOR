public class TarjetaRegalo implements MetodoPago{

    //monto mayor > 0 && <= 500; y menor o igual
    @Override
    public void procesarPago(double monto) {
        monto = 40;
        System.out.println("Monto total: " + monto);}

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

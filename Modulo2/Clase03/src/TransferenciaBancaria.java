public class TransferenciaBancaria implements MetodoPago{

    //monto mayor o igual => 10;
    @Override
    public void procesarPago(double monto) {
        System.out.println("Pago procesado mediante tranferencia bancaria por un monto de $" + monto + ".");
    }

    @Override
    public String obtenerDetalles() {
        return "Se realizo el pago por transferencia bancaria";
    }

    @Override
    public boolean validarMonto(double monto) {
        return monto >= 10;
    }

}

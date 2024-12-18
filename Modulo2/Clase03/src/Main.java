import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MetodoPago> metodosPagos = new ArrayList<>();

        // Lista de métodos de pago
        metodosPagos.add(new TarjetaCredito());
        metodosPagos.add(new PayPal());
        metodosPagos.add(new TransferenciaBancaria());
        metodosPagos.add(new Bitcoin());
        metodosPagos.add(new TarjetaRegalo());

        // Montos a procesar
        double[] montos = {100, 5000, 5, 0.002, 300};

        for (MetodoPago metodopago : metodosPagos) {
            System.out.printf("%n\nMétodo de Pago: %s.", metodopago.obtenerDetalles());
            for (double monto : montos) {
                if (metodopago.validarMonto(monto)) {
                    metodopago.procesarPago(monto);
                } else {
                    System.out.printf("%nMonto no válido: %s.", monto);
                }
            }
        }

    }
}

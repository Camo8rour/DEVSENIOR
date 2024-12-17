import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MetodoPago> metodosPagos = new ArrayList<>();

        metodosPagos.add(new TarjetaCredito());
    }
}

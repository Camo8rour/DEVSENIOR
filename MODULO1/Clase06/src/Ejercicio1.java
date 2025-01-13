import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        List<String> ventas = Arrays.asList(
                "camisa,2,20.00",
                "pantalon,1,35.50",
                "zapatos,3,50.00",
                "camisa,1,20.00",
                "pantalon,2,35.50");

        //Listas con nuevos datos.
        List<String> productos = new ArrayList<>();
        List<Integer> cantidades = new ArrayList<>();
        List<Double> precios_unitario = new ArrayList<>();

        //Separador de datos.
        for (String datos : ventas){
            String[] division = datos.split(",");

            String producto = division[0];
            int cantidad = Integer.parseInt(division[1]);
            double precio_unitario = Double.parseDouble(division[2]);

            productos.add(producto);
            cantidades.add(cantidad);
            precios_unitario.add(precio_unitario);  
        }

        //Ingreso total de ventas.
        double total_ventas = 0;

        for (double valor : precios_unitario) {
            total_ventas =+ valor;
        }

        System.out.printf("%nIngreso total de las ventas: %d.", total_ventas);

        //Ventas por productos.
        for (int i = 0; i < productos.size(); i++) {
            System.out.printf("%n%nCANTIDAD DE VENTAS POR PRODUCTO");
            System.out.printf("%n%s: %d.", productos.get(i), cantidades.get(i));
        }


    }
}

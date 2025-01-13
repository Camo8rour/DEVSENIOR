import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        List<String> ventas = Arrays.asList(
                "camisa,2,20.00",
                "pantalon,1,35.50",
                "zapatos,3,50.00",
                "camisa,1,20.00",
                "pantalon,2,35.50");

        calculateIncome(ventas); //Ingreso total de ventas.
        
        //Ventas por producto.
        Map<String, Integer> salesProducts = new HashMap<>(); //Mapa que se va a utilizar en el metodo bestSeller.
        countSales(ventas, salesProducts);

        filterHigherSales(ventas); //Flitro de ventas.

        bestSeller(salesProducts); //Producto más vendido.

    }

    private static void calculateIncome(List<String> ventas) {
        double total_income = 0.0;
        for (String valores : ventas){
            String[] division = valores.split(",");
            int cantidad = Integer.parseInt(division[1]);
            double precio_unitario = Double.parseDouble(division[2]);
            total_income += (cantidad * precio_unitario);
        }

        System.out.printf("%nIngreso total de las ventas: $%.2f.", total_income);
    }

    private static void countSales(List<String> ventas, Map<String, Integer> salesProducts) {
        for (String valores : ventas){
            String[] division = valores.split(",");
            String producto = division[0];
            int cantidad = Integer.parseInt(division[1]);

            salesProducts.put(producto, salesProducts.getOrDefault(producto, 0) + cantidad);
        }

        System.out.printf("%n%nCANTIDAD DE VENTAS POR PRODUCTO");
        for (String clave : salesProducts.keySet()) {
                System.out.printf("%n%s: %d.", clave, salesProducts.get(clave));
        }
    }

    private static void filterHigherSales(List<String> ventas) {
        double specificAmount = 40.00;
        List<String> filter = new ArrayList<>();

        for (String sale : ventas) {
            String[] division = sale.split(",");
            int cantidad = Integer.parseInt(division[1]);
            double precio_unitario = Double.parseDouble(division[2]);
            double saleValue = cantidad * precio_unitario;

            if(saleValue > specificAmount){
                filter.add(sale);
            }
        }

        System.out.printf("%n%nVENTAS MAYORES A $%s.%n", specificAmount);
        System.out.println(filter);
    }

    private static void bestSeller(Map<String, Integer> salesProducts) {
        String bestSelling = null;
        int count = 0;

        for (Map.Entry<String, Integer> selling : salesProducts.entrySet()){
            if(selling.getValue() > count){
                bestSelling = selling.getKey();
                count = selling.getValue();
            }
        }

        System.out.printf("%nEl producto mas vendido es: %s.", bestSelling);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<String> facturas = Arrays.asList(
                "F001,ClienteA,1000.00,19",
                "F002,ClienteB,1500.00,19",
                "F003,ClienteA,2000.00,19",
                "F004,ClienteC,2500.00,19",
                "F005,ClienteB,3000.00,19");

        calculateAmountIva(facturas); // Monto total con IVA.

        Map<String, Double> clientIncome = new HashMap<>();
        calculateClientIncome(facturas, clientIncome); // Ingreso total por cliente.

        billFilter(facturas); // Filtro de facturas "Mayores a un valor específico".

        higherIncomeClient(clientIncome); // Cliente con mayor ingreso total.
    }

    private static void calculateAmountIva(List<String> facturas) {
        Map<String, Double> amountIva = new HashMap<>();

        for (String bills : facturas) {
            String[] division = bills.split(",");
            String numero_factura = division[0];
            double monto_total = Double.parseDouble(division[2]);
            double iva = Double.parseDouble(division[3]);
            double ivaMonto = monto_total + (monto_total * iva / 100);

            amountIva.put(numero_factura, amountIva.getOrDefault(numero_factura, (double) 0) + ivaMonto);
        }

        System.out.printf("%n%nMONTO TOTAL CON IVA:");
        for (String clave : amountIva.keySet()) {
            System.out.printf("%n%s: %.2f.", clave, amountIva.get(clave));
        }
    }

    private static void calculateClientIncome(List<String> facturas, Map<String, Double> clientIncome) {

        for (String bills : facturas) {
            String[] division = bills.split(",");
            String cliente = division[1];
            double monto_total = Double.parseDouble(division[2]);
            double iva = Double.parseDouble(division[3]);
            double ivaMonto = monto_total + (monto_total * iva / 100);

            clientIncome.put(cliente, clientIncome.getOrDefault(cliente, (double) 0) + ivaMonto);
        }

        System.out.printf("%n%nESTUDIANTES POR MATERIA:");
        for (String clave : clientIncome.keySet()) {
            System.out.printf("%n%s: %.2f.", clave, clientIncome.get(clave));
        }
    }

    private static void billFilter(List<String> facturas) {
        Double specificAmount = 2000.00;
        List<String> billsValue = new ArrayList<>();

        for (String bills : facturas) {
            String[] division = bills.split(",");
            double monto_total = Double.parseDouble(division[2]);

            if (monto_total > specificAmount) {
                billsValue.add(bills);
            }
        }

        System.out.printf("%n%nFACTURAS MAYORES A %s.%n", specificAmount);
        System.out.println(billsValue);
    }

    private static void higherIncomeClient(Map<String, Double> clientIncome) {
        String higherIncome = null;
        double count = 0.0;

        for (Map.Entry<String, Double> bill : clientIncome.entrySet()){
            if(bill.getValue() > count){
                higherIncome = bill.getKey();
                count = bill.getValue();
            }
        }

        System.out.printf("%nEl cliente con el mayor ingreso total es: %s.", higherIncome);
    }
}

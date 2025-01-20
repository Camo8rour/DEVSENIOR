import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<String> productos = Arrays.asList(
                "TabletX,LoteA,8",
                "SmartphoneY,LoteB,7",
                "SmartwatchZ,LoteC,6",
                "LaptopW,LoteD,9",
                "TabletX,LoteE,8");

        List<String> inspecciones = Arrays.asList(
                "LoteA, funcionalidad, 85",
                "LoteB, seguridad, 92",
                "LoteC, funcionalidad, 75",
                "LoteD, seguridad, 60",
                "LoteA, seguridad, 88",
                "LoteC, seguridad, 82",
                "LoteB, funcionalidad, 80");

        List<String> fallos = Arrays.asList(
                "LoteA, sobrecalentamiento, 3",
                "LoteB, pantalla, 5",
                "LoteC, batería, 2",
                "LoteD, sobrecalentamiento, 7",
                "LoteA, pantalla, 2");

        System.out.println("""

                |---------------------------------------------------------|
                |       CONTROL DE CALIDAD DE FÁBRICA DE ELECTRÓNICA      |
                |---------------------------------------------------------|
                        """);

        lotPassRate(inspecciones); // Índice de Aprobación por Lote.

        lotsComplexityApproval(productos, inspecciones); // Lotes con complejidad alta y baja aprobación.

        commonFailureTypes(fallos); // Tipos de fallos frecuentes.

        batchMajorFailures(fallos, productos); // Lote con mayor incidencia de fallos.

        averageQualityTypeInspection(inspecciones); // Calidad promedio por tipo de inspección.

        lotsCriticalFailuresKeyInspections(productos, inspecciones, fallos); // Lotes con fallos críticos en
                                                                             // inspecciones clave.

        processImprovement(productos, inspecciones); // Simulación de mejora de procesos.
    }

    private static void lotPassRate(List<String> inspecciones) {
        Map<String, Double> batchApproval = new HashMap<>();
        Map<String, Integer> loteCount = new HashMap<>();
        List<String> lowerApproval = new ArrayList<>();

        for (String inspection : inspecciones) {
            String[] division = inspection.split(",");
            String lote = division[0];
            double porcenttaje_aprobacion = Double.parseDouble(division[2]);

            batchApproval.put(lote, batchApproval.getOrDefault(lote, (double) 0) + porcenttaje_aprobacion);
            loteCount.put(lote, loteCount.getOrDefault(lote, 0) + 1);

        }

        System.out.printf("%nÍNDICE DE APROBACIÓN POR LOTE");
        for (String clave : batchApproval.keySet()) {
            double average = batchApproval.get(clave) / loteCount.get(clave);

            if (average < 80) {
                lowerApproval.add(clave + ": " + average);
            }

            System.out.printf("%n%s: %.1f.", clave, batchApproval.get(clave) / loteCount.get(clave));
        }
        System.out.printf("\nLotes con baja aprobación: %s.%n%n", lowerApproval);

    }

    private static void lotsComplexityApproval(List<String> productos, List<String> inspecciones) {
        Map<String, Double> batchApproval = new HashMap<>();
        Map<String, Integer> loteCount = new HashMap<>();
        List<String> loteComplexity = new ArrayList<>();
        Map<String, Double> loteComplexityMap = new HashMap<>();
        double complejidad;
        double average;

        for (String products : productos) {
            String[] division = products.split(",");
            complejidad = Double.parseDouble(division[2]);

            if (complejidad > 7) {
                loteComplexity.add(division[1]);
                loteComplexityMap.put(division[1], complejidad);
            }
        }

        for (String inspection : inspecciones) {
            String[] division = inspection.split(",");
            String lote = division[0];
            double porcentajeAprobacion = Double.parseDouble(division[2]);

            batchApproval.put(lote, batchApproval.getOrDefault(lote, 0.0) + porcentajeAprobacion);
            loteCount.put(lote, loteCount.getOrDefault(lote, 0) + 1);
        }

        List<String> complexityApproval = new ArrayList<>();
        for (String clave : batchApproval.keySet()) {
            average = batchApproval.get(clave) / loteCount.get(clave);

            if (loteComplexity.contains(clave) && average < 85) {
                double complejidadLote = loteComplexityMap.get(clave);
                complexityApproval
                        .add("Lote: " + clave + ", Complejidad: " + complejidadLote + ", Aprobación: " + average);
            }
        }

        System.out.println("Lotes con complejidad superior a 7 y aprobación inferior al 85%:");
        for (String end : complexityApproval) {
            System.out.println(end);
        }

    }

    private static void commonFailureTypes(List<String> fallos) {
        Map<String, Integer> failureType = new HashMap<>();
        Map<String, Set<String>> batchFailure = new HashMap<>();

        for (String failure : fallos) {
            String[] division = failure.split(",");
            String lote = division[0].trim();
            String tipoFallo = division[1].trim();
            int cantidadFallos = Integer.parseInt(division[2].trim());

            failureType.put(tipoFallo, failureType.getOrDefault(tipoFallo, 0) + cantidadFallos);

            batchFailure.putIfAbsent(tipoFallo, new HashSet<>());
            batchFailure.get(tipoFallo).add(lote);
        }

        System.out.println("\nTIPOS DE FALLOS FRECUENTES");
        System.out.println("Cantidad de fallos por cada tipo de fallo:");

        for (String tipoFallo : failureType.keySet()) {
            System.out.printf("%s: %d fallos\n", tipoFallo, failureType.get(tipoFallo));
        }

        System.out.println("Fallos más frecuentes (en al menos 3 lotes):");
        for (String tipoFallo : batchFailure.keySet()) {
            if (batchFailure.get(tipoFallo).size() >= 3) {
                System.out.printf("%s: Aparece en %d lotes\n", tipoFallo, batchFailure.get(tipoFallo).size());
            } else {
                System.out.print("- ");
            }
        }
    }

    private static void batchMajorFailures(List<String> fallos, List<String> productos) {
        Map<String, Integer> lotFailures = new HashMap<>();
        Map<String, Map<String, Integer>> lotFailureTypes = new HashMap<>();

        for (String fallo : fallos) {
            String[] partes = fallo.split(", ");
            String lote = partes[0];
            String tipo_fallo = partes[1];
            int cantidad = Integer.parseInt(partes[2]);

            lotFailures.put(lote, lotFailures.getOrDefault(lote, 0) + cantidad);

            lotFailureTypes.putIfAbsent(lote, new HashMap<>());
            lotFailureTypes.get(lote).put(tipo_fallo, lotFailureTypes.get(lote).getOrDefault(tipo_fallo, 0) + cantidad);
        }

        String lotWithMostFailures = Collections.max(lotFailures.entrySet(), Map.Entry.comparingByValue()).getKey();

        String productWithMostFailures = productos.stream()
                .filter(p -> p.contains(lotWithMostFailures))
                .map(p -> p.split(",")[0])
                .findFirst()
                .orElse("Producto no encontrado");

        Map<String, Integer> failuresInLot = lotFailureTypes.get(lotWithMostFailures);
        String mostFrequentFailureType = Collections.max(failuresInLot.entrySet(), Map.Entry.comparingByValue())
                .getKey();

        System.out.println("El lote con más fallos es: " + lotWithMostFailures);
        System.out.println("Producto asociado: " + productWithMostFailures);
        System.out.println("El tipo de fallo más frecuente en este lote es: " + mostFrequentFailureType);
    }

    private static void averageQualityTypeInspection(List<String> inspecciones) {
        Map<String, List<Integer>> inspectionsType = new HashMap<>();

        for (String inspection : inspecciones) {
            String[] division = inspection.split(", ");
            String tipo_inspeccion = division[1];
            int porcentaje_aprobacion = Integer.parseInt(division[2]);

            inspectionsType.putIfAbsent(tipo_inspeccion, new ArrayList<>());
            inspectionsType.get(tipo_inspeccion).add(porcentaje_aprobacion);
        }

        Map<String, Double> averageType = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : inspectionsType.entrySet()) {
            String type = entry.getKey();
            List<Integer> approvalPercentage = entry.getValue();
            double average = approvalPercentage.stream().mapToInt(Integer::intValue).average().orElse(0);
            averageType.put(type, average);
        }

        String typeLowerAverage = Collections.min(averageType.entrySet(), Map.Entry.comparingByValue()).getKey();
        double LowerAverage = averageType.get(typeLowerAverage);

        System.out.println("\nPromedio de aprobación por tipo de inspección:");
        for (Map.Entry<String, Double> entry : averageType.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("El tipo de inspección con la calificación promedio más baja es: " + typeLowerAverage);
        System.out.println("Con un promedio de: " + LowerAverage);
    }

    private static void lotsCriticalFailuresKeyInspections(List<String> productos, List<String> inspecciones,
            List<String> fallos) {
        Map<String, Double> batchApproval = new HashMap<>();
        Map<String, Integer> lotCount = new HashMap<>();
        Map<String, String> lotFailures = new HashMap<>();
        Map<String, Double> batchComplexityMap = new HashMap<>();

        double complexity;
        double average;

        for (String product : productos) {
            String[] division = product.split(",");
            complexity = Double.parseDouble(division[2]);
            batchComplexityMap.put(division[1], complexity); 
        }

        for (String inspection : inspecciones) {
            String[] division = inspection.split(",");
            String lot = division[0];
            double approvalPercentage = Double.parseDouble(division[2]);

            batchApproval.put(lot, batchApproval.getOrDefault(lot, 0.0) + approvalPercentage);
            lotCount.put(lot, lotCount.getOrDefault(lot, 0) + 1);
        }

        for (String failure : fallos) {
            String[] division = failure.split(",");
            String lot = division[0];
            String failureType = division[1];

            lotFailures.put(lot, failureType);
        }

        List<String> criticalLots = new ArrayList<>();
        for (String lot : batchApproval.keySet()) {
            average = batchApproval.get(lot) / lotCount.get(lot);

            if (average < 75 && lotFailures.containsKey(lot)) {
                String failureType = lotFailures.get(lot);
                criticalLots.add("Lote: " + lot + ", Fallos: " + failureType + ", Aprobacion: " + average);
            }
        }

        System.out.println("\nLotes críticos con fallos de seguridad y aprobación < 75%:");
        for (String criticalLot : criticalLots) {
            System.out.println(criticalLot);
        }
    }

    private static void processImprovement(List<String> productos, List<String> inspecciones) {
        Map<String, Double> batchApproval = new HashMap<>();
        Map<String, Integer> lotCount = new HashMap<>();
        Map<String, Double> batchComplexityMap = new HashMap<>();
        double complexity;
        double average;

        for (String product : productos) {
            String[] division = product.split(",");
            complexity = Double.parseDouble(division[2]);
            batchComplexityMap.put(division[1], complexity);
        }

        for (String inspection : inspecciones) {
            String[] division = inspection.split(",");
            String lot = division[0];
            double approvalPercentage = Double.parseDouble(division[2]);

            batchApproval.put(lot, batchApproval.getOrDefault(lot, 0.0) + approvalPercentage);
            lotCount.put(lot, lotCount.getOrDefault(lot, 0) + 1);
        }

        System.out.println("\nÍndices de aprobación antes de la mejora:");
        for (String lot : batchApproval.keySet()) {
            average = batchApproval.get(lot) / lotCount.get(lot);
            System.out.println("Lote: " + lot + ", Aprobación: " + average);
        }

        System.out.println("Índices de aprobación después de la mejora del 5%:");
        for (String lot : batchApproval.keySet()) {
            average = batchApproval.get(lot) / lotCount.get(lot);

            if (batchComplexityMap.get(lot) > 7) {
                average *= 1.05;
            }
            System.out.println("Lote: " + lot + ", Aprobación: " + average);
        }
    }
}

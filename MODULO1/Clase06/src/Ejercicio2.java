import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio2 {
    public static void main(String[] args) {
        List<String> calificaciones = Arrays.asList(
                "Juan,Matematicas,85",
                "Ana,Historia,90",
                "Pedro,Matematicas,70",
                "Juan,Historia,75",
                "Ana,Matematicas,95",
                "Pedro,Historia,80");

        calculateAverage(calificaciones); // Calcula el promedio.

        studentsSubject(calificaciones); // Estudiantes por materia.

        ratingsFilter(calificaciones); // Filtro de calificaciones mayores a el valor.

        subjectHighestAverage(calificaciones); // Materia con el promedio mas alto.
    }

    private static void calculateAverage(List<String> calificaciones){
        Map<String, Double> qualificationStudents = new HashMap<>();

        for (String qualification : calificaciones) {
            String[] division = qualification.split(",");
            String estudiante = division[0];
            double calificacion = Integer.parseInt(division[2]);
            qualificationStudents.put(estudiante, qualificationStudents.getOrDefault(estudiante, (double) 0) + calificacion);
        }

        System.out.printf("%n%nPROMEDIO DE ESTIDIANTES");
        for (String clave : qualificationStudents.keySet()) {
            System.out.printf("%n%s: %.1f.", clave, qualificationStudents.get(clave) / 2);
        }
    }

    private static void studentsSubject(List<String> calificaciones){
        
    }

    private static void ratingsFilter(List<String> calificaciones){
        int specificAmount = 80;
        List<String> filter = new ArrayList<>();

        for (String qualifications : calificaciones) {
            String[] division = qualifications.split(",");
            int calificacion = Integer.parseInt(division[2]);

            if (calificacion > specificAmount) {
                filter.add(qualifications);
            }
        }

        System.out.printf("%n%nCALIFICACIONES MAYORES A %s.%n", specificAmount);
        System.out.println(filter);
    }

    private static void subjectHighestAverage(List<String> calificaciones){

    }
}

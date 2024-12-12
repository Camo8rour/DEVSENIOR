import java.util.ArrayList;
import java.util.List;

/*
 * Clase 1 Ejercicio Adicional:
 * Crear un sistema para gestionar información de estudiantes en un colegio.
 * Define la clase Estudiante con atributos:
 * -	nombre, edad, promedio
 * 
 * Métodos:
 * mostrarDetalles(): Muestra la información del estudiante.
 * esAprobado(): Devuelve true si el promedio es mayor o igual a 3.0.
 * 
 * En la clase principal (Main):
 * Crea una lista de estudiantes.
 * Muestra la información de todos los estudiantes.
 * Indica si están aprobados o no.
 */

public class Main {
    public static void main(String[] args) throws Exception {

        // Lista de estudiantes
        List<Student> students = new ArrayList<>();

        // Estudiantes de la lista
        students.add(new Student("Juan Pérez", 15, 4.2f));
        students.add(new Student("María López", 14, 2.8f));
        students.add(new Student("Carlos Gómez", 16, 3.5f));

        // Información de todos los estudiantes
        System.out.printf("%n*****DETALLES DE ESTUDIANTES*****%n");
        for (Student student : students) {
            student.mostrarDetalles();
            System.out.println("¿Está aprobado?: " + (student.esAprobado() ? "Sí" : "No"));
            System.out.println();
        }
    }
}

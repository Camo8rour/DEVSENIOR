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
        List<Student> students = new ArrayList<>();

        students.add(new Student("Camilo", 20, 4.5));
        students.add(new Student("Laura", 22, 3.8));
        students.add(new Student("Andrés", 19, 2.5));

        for (Student estudiante : students) {
            estudiante.mostrarDetalles();
            System.out.println("¿Está aprobado?: " + (estudiante.esAprobado() ? "Sí" : "No"));
            System.out.println();
        }
    }
}

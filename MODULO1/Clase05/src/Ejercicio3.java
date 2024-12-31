import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        System.out.printf("%n\t GESTIÓN DE TAREAS%n");
        System.out.println("1. Agregar tareas.");
        System.out.println("2. Eliminar tareas.");
        System.out.println("3. Mostrar tareas.");
        System.out.println("4. Agregar tarea por pocisión.");
        System.out.println("5. Salir.");
        System.out.print("--> ");
        int num = request.nextInt();

        System.out.printf("%nNúmero ingresado: %d.", num);

        request.close();
    }
}

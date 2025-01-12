import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        var request = new Scanner(System.in);

        int option;
        System.out.println("""

                ---------------------------------------
                |        GESTIÓN DE ESTUDIANTES       |
                ---------------------------------------""");

        do {

            System.out.printf("%n%n\tMENÚ DE OPCIONES.%n");
            System.out.println("1. Agregar estudiantes.");
            System.out.println("2. Eliminar estudiantes.");
            System.out.println("3. Mostrar los estudiantes.");
            System.out.println("4. Salir.");
            System.out.print("--> ");
            option = request.nextInt();

            switch (option) {
                case 1:
                    newStudents(request, students); //Agregar la tarea.

                    pressEnter(request);
                    break;

                case 2:
                    deleteStudent(request, students); //Elimina la tarea.

                    request.nextLine();
                    pressEnter(request);
                    break;

                case 3:
                    printStudents(students); //Muestra las tareas.

                    request.nextLine();
                    pressEnter(request);
                    break;

                case 4:
                    System.out.printf("%nSaliendo...");
                    break;

                default:
                    System.err.println("¡¡¡Error!!!");

                    request.nextLine();
                    pressEnter(request);
                    break;
            }

        } while (option != 4);

        request.close();
    }

    private static void newStudents(Scanner request, ArrayList<String> students) {
        System.out.printf("%nNombre del estudiante: ");
        request.nextLine();
        String student = request.nextLine();

        students.add(student);
        System.out.printf("%nEstudiante ingresado con éxito.%n");
    }

    private static void deleteStudent(Scanner request, ArrayList<String> students) {
        int position;

        if (students.isEmpty()) {
            System.out.printf("%nNo hay ningun estudiante para eliminar.");
        }else{

            System.out.printf("%nIngresé el número de la pocición del estudiante que desea eliminar: ");
            position = request.nextInt() - 1;
            
            if (position >= 0 && position < students.size()) {
                students.remove(position);
                System.out.printf("%nEl estudiante en la posición %d fue eliminada con éxito.", (position + 1));
            } else {
                System.out.printf("%nLa posición ingresada es incorrecta.");
            }
        }
    }

    private static void printStudents(ArrayList<String> students) {
        if (students.isEmpty()) {
            System.out.printf("%nNo hay ningun estudiante inscrito en el curso.");
        } else {
            System.out.printf("%nLista de estudiantes:");
            for (String student : students) {
                System.out.printf("%n-%s.", student);
            }
        }
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean completed;

    //Constructor.
    public Task(String name) {
        this.name = name;
        this.completed = false;
    }

    // Método para modificar el estado de la tarea.
    public void modifyTask() {
        if (this.completed == true) {
            this.completed = false;
        } else {
            this.completed = true;
        }
    }

    // Método para mostrar el estado de la tarea.
    public String showTask() {
        return name + " - " + (completed ? "Completada" : "Pendiente");
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        ArrayList<Task> taskList = new ArrayList<>(); // Lista para almacenar las tareas.

        showMenu(request, taskList);

        request.close();
    }

    private static void showMenu(Scanner request, ArrayList<Task> taskList) {
        int option;
        System.out.println("""

                ---------------------------------------
                |           GESTIÓN DE TAREAS         |
                ---------------------------------------""");

        do {

            System.out.printf("%n%n\tMENÚ DE OPCIONES.%n");
            System.out.println("1. Agregar nueva tarea.");
            System.out.println("2. Eliminar tareas completadas.");
            System.out.println("3. Mostrar todas las tareas.");
            System.out.println("4. Mostrar tarea por posición.");
            System.out.println("5. Modificar estado de la tarea.");
            System.out.println("6. Salir.");
            System.out.print("--> ");
            option = request.nextInt();

            switch (option) {
                case 1:
                    newTask(request, taskList); //Agregar la tarea.

                    pressEnter(request);
                    break;

                case 2:
                    deleteTask(request, taskList); //Elimina la tarea.

                    request.nextLine();
                    pressEnter(request);
                    break;

                case 3:
                    printList(taskList); //Muestra las tareas.

                    request.nextLine();
                    pressEnter(request);
                    break;

                case 4:
                    taskByPosition(request, taskList); //Muestra la tarea por posición.

                    request.nextLine();
                    pressEnter(request);
                    break;

                case 5:
                    modifiedTask(request, taskList); //Modifica el estado de la tarea.

                    request.nextLine();
                    pressEnter(request);
                    break;

                case 6:
                    System.out.printf("%nSaliendo...");
                    break;

                default:
                    System.err.println("¡¡¡Error!!!");

                    request.nextLine();
                    pressEnter(request);
                    break;
            }

        } while (option != 6);
    }

    private static void modifiedTask(Scanner request, ArrayList<Task> taskList) {
        int position;
        System.out.printf("%nIngresé el número de la posición de la tarea a modificar: ");
        position = request.nextInt() - 1;

        if (position >= 0 && position < taskList.size()) {
            taskList.get(position).modifyTask();
            System.out.printf("%nTarea en la posición %d fue modificada.", (position + 1));
        } else {
            System.out.printf("%nLa posición ingresada es incorrecta.");
        }
    }

    private static void taskByPosition(Scanner request, ArrayList<Task> taskList) {
        int position;
        System.out.printf("%nIngresé el número de la posición de la tarea a consultar: ");
        position = request.nextInt() - 1;

        if (position >= 0 && position < taskList.size()) {
            System.out.printf("%nTarea en la posición %d: %s.", (position + 1), taskList.get(position).showTask());
        } else {
            System.out.printf("%nLa posición ingresada es incorrecta.");
        }
    }

    private static void printList(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.printf("%nNo hay ninguna tarea.");
        } else {
            System.out.println("Lista de tareas:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.printf("%d. %s\n", (i + 1), taskList.get(i).showTask());
            }
        }
    }

    private static void deleteTask(Scanner request, ArrayList<Task> taskList) {
        int position;
        System.out.printf("%nIngresé el número de la pocición de la tarea que desea eliminar: ");
        position = request.nextInt() - 1;

        if (position >= 0 && position < taskList.size()) {
            taskList.remove(position);
            System.out.printf("%nLa tarea en la posición %d fue eliminada con éxito.", (position + 1));
        } else {
            System.out.printf("%nLa posición ingresada es incorrecta.");
        }
    }

    private static void newTask(Scanner request, ArrayList<Task> taskList) {
        System.out.printf("%nAgregue la tarea: ");
        request.nextLine();
        String task = request.nextLine();

        taskList.add(new Task(task));
        System.out.printf("%nTarea ingresada con éxito.%n");
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }
}

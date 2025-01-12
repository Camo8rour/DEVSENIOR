import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Queue<String> customersQueue = new LinkedList<>();

        var request = new Scanner(System.in);
        int option;

        System.out.println("""

                ---------------------------------------
                |           SIMULADOR DE BANCO         |
                ---------------------------------------""");

        do {
            System.out.printf("%n%n\tMENÚ DE OPCIONES.%n");
            System.out.println("1. Ingreso de un cliente.");
            System.out.println("2. Atender un cliente.");
            System.out.println("3. Mostrar estado de la cola.");
            System.out.println("4. Salir.");
            System.out.print("--> ");
            option = request.nextInt();
            request.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String customers = request.nextLine();
                    addCustomer(customers, customersQueue); // Método para agregar a un cliente.

                    pressEnter(request);
                    break;
                case 2:
                    serveCustomer(customersQueue); // Método para atender a un cliente.

                    pressEnter(request);
                    break;
                case 3:
                    showQueueStatus(customersQueue); // Método para mostrar el estado actual de la cola.

                    pressEnter(request);
                    break;
                case 4:
                    System.out.printf("%nSaliendo...");

                    pressEnter(request);
                    break;
                default:
                    System.err.println("¡¡¡Error!!!");

                    pressEnter(request);
            }
        } while (option != 4);

        request.close();
    }

    private static void addCustomer(String customers, Queue<String> customersQueue) {
        customersQueue.offer(customers);
        System.out.printf("%nCliente %s ha llegado al banco.", customers);
    }

    private static void serveCustomer(Queue<String> customersQueue) {
        if (customersQueue.isEmpty()) {
            System.out.println("No hay clientes en la cola para atender.");
        } else {
            String clienteAtendido = customersQueue.poll();
            System.out.printf("%nCliente %s ha sido atendido.", clienteAtendido);
        }
    }

    private static void showQueueStatus(Queue<String> customersQueue) {
        if (customersQueue.isEmpty()) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("Estado actual de la cola:");
            for (String customer : customersQueue) {
                System.out.println(customer);
            }
        }
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }

}

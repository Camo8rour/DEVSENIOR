import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try (Scanner request = new Scanner(System.in)) {
            GestionClientes gestionClientes = new GestionClientes();
            GestionReservas gestionReservas = new GestionReservas(gestionClientes);

            showMenu(request, gestionClientes, gestionReservas);
        }
    }

    private static void showMenu(Scanner request, GestionClientes gestionClientes, GestionReservas gestionReservas) {
        byte n;
        do {
            System.out.printf("%n-----------------------------------------------------%n");
            System.out.println("\t \t MENÚ DE OPCIONES");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Registrar cliente.");
            System.out.println("2. Crear reserva.");
            System.out.println("3. Buscar reserva.");
            System.out.println("4. Salir.");
            System.out.print("--> ");
            n = optionNumber(request);

            switch (n) {
                case 1:
                    registrarCliente(request, gestionClientes);
                    pressEnter(request);
                    break;

                case 2:
                    crearReserva(request, gestionReservas);
                    pressEnter(request);
                    break;

                case 3:
                    buscarReserva(request, gestionReservas);
                    pressEnter(request);
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Por favor, ingrese una opción válida.");
            }
        } while (n != 4);
    }

    private static byte optionNumber(Scanner request) {
        byte n = -1;
        boolean isValid = false;
        while (!isValid) {
            try {
                String input = request.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Error. No se puede dejar el campo vacío.");
                    System.out.print("Vuelva a ingresar una opción: \n--> ");
                    continue;
                }
                n = Byte.parseByte(input);

                if (n < 1 || n > 4) {
                    System.out.println("Por favor, ingrese una opción válida.");
                    System.out.print("Vuelva a ingresar una opción: \n--> ");
                } else {
                    isValid = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Debe ingresar un número.");
                System.out.print("Vuelva a ingresar una opción: \n--> ");
            }
        }
        return n;
    }

    private static void registrarCliente(Scanner request, GestionClientes gestionClientes) {
        String id;
        String nombre;

        do {
            System.out.print("Ingrese el ID del cliente: ");
            id = request.nextLine().trim();
            if (id.isEmpty()) {
                System.err.println("Error. El ID no puede estar vacío.");
            }
        } while (id.isEmpty());

        do {
            System.out.print("Ingrese el nombre del cliente: ");
            nombre = request.nextLine().trim();
            if (nombre.isEmpty()) {
                System.err.println("Error. El nombre no puede estar vacío.");
            }
        } while (nombre.isEmpty());

        gestionClientes.registrarCliente(id, nombre);
        System.out.println("Cliente registrado exitosamente.");
    }

    private static void crearReserva(Scanner request, GestionReservas gestionReservas) {
        String clienteId;
        String fechaInicio;
        String fechaFin;

        System.out.print("Ingrese el ID del cliente: ");
        clienteId = request.nextLine().trim();

        System.out.print("Ingrese la fecha de inicio de la reserva (YYYY-MM-DD): ");
        fechaInicio = request.nextLine().trim();

        System.out.print("Ingrese la fecha de fin de la reserva (YYYY-MM-DD): ");
        fechaFin = request.nextLine().trim();

        try {
            gestionReservas.crearReserva(clienteId, fechaInicio, fechaFin);
            System.out.println("Reserva creada con éxito.");
        } catch (ReservaInvalidaException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void buscarReserva(Scanner request, GestionReservas gestionReservas) {
        String clienteId;
        String fechaInicio;

        System.out.print("Ingrese el ID del cliente para buscar la reserva: ");
        clienteId = request.nextLine().trim();

        System.out.print("Ingrese la fecha de inicio de la reserva a buscar (YYYY-MM-DD): ");
        fechaInicio = request.nextLine().trim();

        try {
            String reserva = gestionReservas.buscarReserva(clienteId, fechaInicio);
            System.out.println(reserva);
        } catch (ClienteNoEncontradoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }
}
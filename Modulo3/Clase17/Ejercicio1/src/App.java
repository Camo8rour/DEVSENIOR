import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner request = new Scanner(System.in)) {
            Inventario inventario = new Inventario();
            showMenu(request, inventario);
        }
    }

    private static void showMenu(Scanner request, Inventario inventario) {
        byte n;

        do {
            System.out.printf("%n-----------------------------------------------------%n");
            System.out.println("\t \t MENÚ DE OPCIONES");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Agregar producto.");
            System.out.println("2. Eliminar producto.");
            System.out.println("3. Buscar producto.");
            System.out.println("4. Actualizar cantidad.");
            System.out.println("5. Salir.");
            System.out.print("--> ");
            n = optionNumber(request);

            switch (n) {
                case 1:
                    agregarProducto(request, inventario);
                    pressEnter(request);
                    break;

                case 2:
                    eliminarProducto(request, inventario);
                    pressEnter(request);
                    break;

                case 3:
                    buscarProducto(request, inventario);
                    pressEnter(request);
                    break;

                case 4:
                    actualizarCantidad(request, inventario);
                    pressEnter(request);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Por favor, ingrese una opción valida.");
            }

        } while (n != 5);
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

                if (n < 1 || n > 5) {
                    System.out.println("Por favor, ingrese una opcion valida.");
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

    private static void agregarProducto(Scanner request, Inventario inventario) {
        String nombre;
        do {
            System.out.print("Ingrese el nombre del producto: ");
            nombre = request.nextLine().trim();

            if (nombre.isEmpty()) {
                System.err.println("Error. No se puede dejar el campo vacío.");
            }
        } while (nombre.isEmpty());

        int cantidad = validInteger(request, "Ingrese la cantidad del producto: ");
        while (cantidad < 0) {
            System.out.println("Error: La cantidad no puede ser negativa.");
            cantidad = validInteger(request, "Ingrese la cantidad del producto: ");
        }

        inventario.agregarProducto(nombre, cantidad);
        System.out.println("Producto agregado exitosamente.");
    }

    private static void eliminarProducto(Scanner request, Inventario inventario) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombreEliminar = request.nextLine().trim();

        if (nombreEliminar.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío.");
            return;
        }

        try {
            inventario.eliminarProducto(nombreEliminar);
            System.out.printf("%nEl producto %s ha sido eliminado.", nombreEliminar);
        } catch (ProductoNoEncontradoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void buscarProducto(Scanner request, Inventario inventario) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreBuscar = request.nextLine().trim();

        if (nombreBuscar.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío.");
            return;
        }

        try {
            Integer nuevaCantidad = inventario.buscarProducto(nombreBuscar);
            System.out.println("Cantidad de " + nombreBuscar + ": " + nuevaCantidad);
        } catch (ProductoNoEncontradoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarCantidad(Scanner request, Inventario inventario) {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String name = request.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("El nombre del producto no puede estar vacío.");
            return;
        }

        int nuevaCantidad = validInteger(request, "Ingrese la nueva cantidad del producto: ");

        while (nuevaCantidad < 0) {
            System.err.println("Error: La cantidad no puede ser negativa.");
            nuevaCantidad = validInteger(request, "Ingrese la nueva cantidad del producto: ");
        }

        try {
            inventario.actualizarCantidad(name, nuevaCantidad);
            System.out.println("Cantidad actualizada.");
        } catch (ProductoNoEncontradoException | CantidadInvalidaException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static int validInteger(Scanner request, String producto) {
        int num = -1;

        while (num < 0) {
            System.out.print(producto);
            String input = request.nextLine().trim();

            if (input.isEmpty()) {
                System.err.println("Error: No se puede dejar la cantidad vacía.");
                continue;
            }

            try {
                num = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Error: Debe ingresar un número entero.");
                continue;
            }

            if (num < 0) {
                System.err.println("Error: La cantidad no puede ser negativa.");
            }
        }

        return num;
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }
}
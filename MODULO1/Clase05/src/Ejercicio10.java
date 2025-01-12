import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        List<String> settings = new ArrayList<>();

        var request = new Scanner(System.in);
        int option;

        System.out.println("""

                ---------------------------------------
                |      GESTIÓN DE CONFIGURACIONES      |
                ---------------------------------------""");

        do {
            System.out.printf("%n%n\tMENÚ DE OPCIONES.%n");
            System.out.println("1. Agregar configuración.");
            System.out.println("2. Actualizar configuración.");
            System.out.println("3. Mostrar todas las configuraciones.");
            System.out.println("4. Salir.");
            System.out.print("--> ");
            option = request.nextInt();
            request.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre de la configuración: ");
                    String name = request.nextLine();
                    addSettings(name, settings); // Método para agregar configuración.

                    pressEnter(request);
                    break;
                case 2:
                    updateSettings(request, settings); // Método para actualizar configuración.

                    pressEnter(request);
                    break;
                case 3:
                    showSettings(settings); // Método para mostrar configuraciones.

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

    private static void addSettings(String name, List<String> settings) {
        if (settings.add(name)) {
            System.out.printf("%nLa configuración %s ha sido agregada.", name);
        } else {
            System.out.println("La configuración ya existe.");
        }
    }

    private static void updateSettings(Scanner request, List<String> settings) {
        if (settings.isEmpty()) {
            System.out.println("No hay configuraciones para actualizar.");
            return;
        }

        System.out.print("Seleccione el número de la configuración que desea actualizar: ");
        int position = request.nextInt();
        request.nextLine();

        if (position < 1 || position > settings.size()) {
            System.out.println("Posición no válida.");
        } else {
            String removedSetting = settings.remove(position - 1);
            System.out.printf("%nLa configuración '%s' ha sido actualizada.", removedSetting);
        }
    }

    private static void showSettings(List<String> settings) {
        if (settings.isEmpty()) {
            System.out.println("No hay configuraciones almacenadas.");
        } else {
            System.out.println("Configuraciones almacenadas:");
            for (int i = 0; i < settings.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, settings.get(i));
            }
        }
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }

}

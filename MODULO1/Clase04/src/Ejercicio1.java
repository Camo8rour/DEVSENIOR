import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showMenu(request);
        request.close();

    }

    private static void showMenu(Scanner request) {
        byte option;

        do {
            System.out.printf("%n-----------------------------------------------------%n");
            System.out.println("\t \t MENÚ DE OPCIONES");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Conversión de temperatura de Celsius a Fahrenheit.");
            System.out.println("2. Conversión de temperatura de Fahrenheit a Celsius.");
            System.out.println("0. Salir del programa.");
            System.out.print("-> ");
            option = request.nextByte();
            request.nextLine();

            switch (option) {
                case 1:
                    calculateFahrenheit(request);
                    break;

                case 2:
                    calculateCelsius(request);
                    break;

                case 0:
                    break;

                default:
                    System.err.println("Ingrese una opción valida.");
                    break;
            }

            if (option != 0) {
                pressEnter(request);
            }

        } while (option != 0);
    }

    private static void pressEnter(Scanner request){
        System.out.printf("%nOprima ENTER para continuar.%n");
        request.nextLine();
    }

    private static void calculateFahrenheit(Scanner request) {
        System.out.print("Ingrese la temperatura en Celsius: ");
        double temperatura = request.nextDouble();
        request.nextLine();

        double celsius = temperatura;
        double fahrenheit = (celsius * (9.0 / 5.0)) + 32;
        System.out.printf("La temperatura en Fahrenheit es: %.1f.", fahrenheit);
    }

    private static void calculateCelsius(Scanner pedir) {
        System.out.print("Ingrese la temperatura en Fahrenheit: ");
        double temperatura = pedir.nextDouble();
        pedir.nextLine();

        double fahrenheit = temperatura;
        double celsius = (fahrenheit - 32) / (9.0 / 5.0);
        System.out.printf("La temperatura en Fahrenheit es: %.1f.", celsius);
    }

}
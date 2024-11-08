import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {
        byte option;

        do {
            System.out.printf("%n-----------------------------------------------------%n");
            System.out.println("\t \t MENÚ DE OPCIONES");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Cálculo de intereses simple.");
            System.out.println("2. Cálculo de intereses complejo.");
            System.out.println("0. Salir del programa.");
            System.out.print("-> ");
            option = reqShow.nextByte();
            reqShow.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingresa el capital inicial: ");
                    double P = reqShow.nextDouble();
                    System.out.print("Ingresa la tasa de intéreses anual (en porcentaje): ");
                    double r = reqShow.nextDouble() / 100;
                    System.out.print("Ingresa el tiempo (en años): ");
                    double t = reqShow.nextDouble();

                    calculateSimple(P, r, t);
                    reqShow.nextLine();
                    break;

                case 2:
                    System.out.print("Ingresa el capital inicial: ");
                    P = reqShow.nextDouble();
                    System.out.print("Ingresa la tasa de intéreses anual (en porcentaje): ");
                    r = reqShow.nextDouble() / 100;
                    System.out.print("Ingresa el tiempo (en años): ");
                    t = reqShow.nextDouble();
                    System.out.print("Ingresa el número de veces que se aplica el interés por compuesto por año: ");
                    double n = reqShow.nextDouble();

                    calculateComplejo(P, r, t, n);
                    reqShow.nextLine();
                    break;

                case 0:
                    break;

                default:
                    System.err.println("Ingrese una opción valida.");
                    break;
            }

            if (option != 0) {
                pressEnter(reqShow);
            }

        } while (option != 0);
    }

    private static void calculateSimple(double P, double r, double t){
        double I = P * r * t;
        System.out.printf("%nEl interés simple es: %.1f.", I);
    }

    private static void calculateComplejo(double P, double r, double t, double n){
        double base = 1 + (r / n);
        double potencia = 1;

        for (int i = 0; i < n * t; i++) {
            potencia *= base;
        }

        double A = P * potencia;
        double I = A - P;
        
        System.out.printf("El monto total después de %.0f años es: %f%n", t, A);
        System.out.printf("El interés compuesto es: %f", I);
    }

    private static void pressEnter(Scanner reqPress){
        System.out.printf("%nOprima ENTER para continuar.%n");
        reqPress.nextLine();
    }
}

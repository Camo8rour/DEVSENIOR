import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner request) {
        int number;

        while (true) {

            System.out.printf("%n\tCALCULO DE FACTORIAL.%n");
            System.out.print("Ingrese un número entero positivo: ");
            if (request.hasNextInt()) {
                number = request.nextInt();

                if (number < 0) {
                    System.out.println("El número debe ser positivo. Inténtelo de nuevo.");
                    request.nextLine();
                    pressEnter(request);
                }else{
                    calculateFactorial(number);
                    break;
                }

            }else{
                System.out.println("Debe ingresar un número entero. Inténtelo de nuevo.");
                request.next();
                request.nextLine();
                pressEnter(request);
            }
        }
    }

    private static void calculateFactorial(int numCal){
        int factorial = 1;

        for (int i = 1; i <= numCal; i++) {
            factorial *= i;
        }

        System.out.printf("El factorial de %d es: %d.", numCal, factorial);
    }

    private static void pressEnter(Scanner reqScanner) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        reqScanner.nextLine();
    }
}

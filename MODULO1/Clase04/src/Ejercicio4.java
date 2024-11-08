import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {
        int number;

        while (true) {

            System.out.printf("%n\tNÚMEROS PRIMOS.%n");
            System.out.print("Ingrese un número entero mayor que 1 (positivo): ");
            if (reqShow.hasNextInt()) {
                number = reqShow.nextInt();

                if (number <= 1) {
                    System.out.println("El número debe ser mayor que 1 (positivo). Inténtelo de nuevo.");
                    reqShow.nextLine();
                    pressEnter(reqShow);
                }else{
                    identiPrimo(number);
                    break;
                }

            }else{
                System.out.println("Debe ingresar un número entero. Inténtelo de nuevo.");
                reqShow.next();
                reqShow.nextLine();
                pressEnter(reqShow);
            }
        }
    }

    private static void identiPrimo(int numId){

        int division;
        int cont = 0;
        for (int i = 1; i <= numId; i++) {
            division = numId % i;
            
            if (division == 0) {
                cont ++;
            }
        }

        if (cont > 1 && cont < 3) {
            System.out.printf("El número %d es primo.", numId);
        }else{
            System.out.printf("El número %d no es primo.", numId);
        }
    }

    private static void pressEnter(Scanner reqScanner) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        reqScanner.nextLine();
    }
}

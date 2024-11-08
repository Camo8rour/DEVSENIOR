import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {
        int number;

        while (true) {

            System.out.printf("%nGENERACIÓN DE TABLAS DE MULTIPLICAR.%n");
            System.out.print("Ingrese un número entero positivo: ");
            if (reqShow.hasNextInt()) {
                number = reqShow.nextInt();

                if (number < 0) {
                    System.out.println("El número debe ser positivo. Inténtelo de nuevo.");
                    reqShow.nextLine();
                    pressEnter(reqShow);
                }else{
                    tablasMultiplicar(number);
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

    private static void tablasMultiplicar(int numTablas) {
        int result;
        for (int i = 1; i <= 10; i++) {
            result = numTablas * i;
            System.out.printf("%d x %d = %d%n", numTablas, i, result);
        }
    }

    private static void pressEnter(Scanner reqPress) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        reqPress.nextLine();
    }
}

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {

        System.out.printf("%n\tPROMEDIO DE LOS NÚMEROS.%n");
        System.out.print("Ingresa el primer número: ");
        int number1 = reqShow.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int number2 = reqShow.nextInt();
        System.out.print("Ingresa el tercer número: ");
        int number3 = reqShow.nextInt();
        
        averageNumber(number1, number2, number3);
    }

    private static void averageNumber(int number1, int number2, int number3) {
        double average = (number1 + number2 + number3)/3;

        System.out.printf("%nEl promedio de los tres números es: %.1f", average);
    }
}

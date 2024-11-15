import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {

        var request = new Scanner(System.in);

        // - Invertir por completo el array.
        // - Ordenar el array de mayor a menor.
        // - Obtener el promedio de los elementos del array.
        // - Encontrar la moda (el número que mas se repite)
        System.out.printf("%nIngrese un número entero (tamaño del array): ");
        int size = request.nextInt();
        int[] number = new int[size];
        int sum = 0;
        int less = Integer.MAX_VALUE;
        int elderly = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            System.out.printf("Ingrese el número entero %s: ", i + 1);
            number[i] = request.nextInt();

            if (number[i] < less) {
                less = number[i];
            }

            if (number[i] > elderly) {
                elderly = number[i];
            }

            sum += number[i];
        }

        float average = sum / size;

        System.out.printf("La suma de todos los números es: %d.%n", sum);
        System.out.printf("El valor máximo  ingresado es: %d.%n", elderly);
        System.out.printf("El valor mínimo ingresado es: %d.%n", less);
        System.out.printf("El promedio de todos los números es: %.2f.%n", average);


        request.close();
    }
}

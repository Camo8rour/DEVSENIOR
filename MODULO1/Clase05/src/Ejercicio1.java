import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {

        var request = new Scanner(System.in);

        // - Invertir por completo el array.
        // - Ordenar el array de mayor a menor.
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

        int left = 0;
        int right = number.length -1;

        while (left < right) {
            int temp = number[left];
            number[left] = number[right];
            number[right] = temp;

            left ++;
            right --;
        }

        System.out.print("Números ingresados en la posicion invertida: ");

        for (int num : number) {
            System.out.printf("%d ", num);
        }
        

        float average = (float) sum / size;

        System.out.printf("Suma de todos los números: %d.%n", sum);
        System.out.printf("Valor máximo  ingresado: %d.%n", elderly);
        System.out.printf("Valor mínimo ingresado: %d.%n", less);
        System.out.printf("Promedio de todos los números: %.2f.%n", average);


        request.close();
    }
}

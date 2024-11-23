import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {

        var request = new Scanner(System.in);

        showProgram(request);

        request.close();
    }

    private static void showProgram(Scanner request) {
        System.out.printf("%nIngrese un número entero (tamaño del array): ");
        int size = request.nextInt();
        int[] number = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.printf("Ingrese el número entero %s: ", i + 1);
            number[i] = request.nextInt();
        }

        //Sumar los números, número máyor, número menor y prómedio de los números.
        operationBasics(number, size);
        
        // Números invertidos.
        invertedNumbers(number);

        // Mayor a menor.
        leastToGreatest(size, number);

        // Moda
        repetitiveNumber(size, number);
    }

    private static void operationBasics(int[] number, int size) {
        int sum = 0;
        int less = Integer.MAX_VALUE;
        int elderly = Integer.MIN_VALUE;

        for (int i = 0; i < size ; i++) {
            // Suma
            sum += number[i];

            // Valor máximo
            if (number[i] > elderly) {
                elderly = number[i];
            }

            // Valor mínimo
            if (number[i] < less) {
                less = number[i];
            }
        }

        // Promedio
        float average = (float) sum / size;

        System.out.printf("Suma de todos los números: %d.%n", sum);
        System.out.printf("Valor máximo  ingresado: %d.%n", elderly);
        System.out.printf("Valor mínimo ingresado: %d.%n", less);
        System.out.printf("Promedio de todos los números: %.2f.%n", average);
    }

    private static void invertedNumbers(int[] number) {
        int left = 0;
        int right = number.length - 1;

        while (left < right) {
            int temp = number[left];
            number[left] = number[right];
            number[right] = temp;

            left++;
            right--;
        }

        System.out.print("Números ingresados en la posicion invertida: ");

        for (int num : number) {
            System.out.printf("%d ", num);
        }
        System.out.printf("%n");
    }

    private static void leastToGreatest(int size, int[] number) {
        for (int o = 1; o < size; o++) {
            int clue = number[o];
            int u = o - 1;

            while (u >= 0 && number[u] < clue) {
                number[u + 1] = number[u];
                u--;
            }

            number[u + 1] = clue;
        }

        System.out.print("Números de mayor a menor: ");

        for (int num : number) {
            System.out.printf("%d ", num);
        }
        System.out.printf("%n");
    }

    private static void repetitiveNumber(int size, int[] number) {
        int moda = number[0];
        int repetitive = 0;

        for (int e = 0; e < size; e++) {
            int frequency = 0;

            for (int f = 0; f < size; f++) {
                if (number[e] == number[f]) {
                    frequency++;
                }
            }

            if (frequency > repetitive) {
                repetitive = frequency;
                moda = number[e];
            }
        }
        System.out.printf("La moda es el número %d y se repite %d veces.", moda, repetitive);
    }

}

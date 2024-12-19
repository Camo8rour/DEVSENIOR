import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        
        var request = new Scanner(System.in);

        showProgram(request);

        request.close();
    }

    private static void showProgram(Scanner showReq) {

        System.out.printf("%nIngrese el tamaño de la dimensión de la matriz.");
        System.out.printf("%n--> ");
        var size = showReq.nextInt();

        int cont = 0;
        int[][] array = new int[size][size];

        //Ingreso de números de la matriz.
        for (int i = 0; i < size; i++) {

            for (int e = 0; e < size; e++) {
                cont ++;
                System.out.printf("Ingrese el número %d: ", cont);
                array[i][e] = showReq.nextInt();
            }
        }
        showReq.nextLine();

        int[][] rotatedArray = new int[size][size];

        // Matriz rotada.
        for (int i = 0; i < size; i++) {
            for (int e = 0; e < size; e++) {
                rotatedArray[e][size - 1 - i] = array[i][e];
            }
        }

        System.out.printf("Matriz %dx%d ingresada:%n", size, size);
        arrayView(array);

        pressEnter(showReq);

        System.out.printf("Matriz %dx%d rotada:%n", size, size);
        arrayView(rotatedArray);

        pressEnter(showReq);
    }

    private static void arrayView(int[][] array) {
        for (int i = 0; i < array.length; i++) {

            for (int e = 0; e < array[i].length; e++) {
                System.out.printf(" %d ", array[i][e]);
            }

            System.out.printf("%n");
        }
    }

    private static void pressEnter(Scanner pressRequest) {
        System.out.printf("%nOprima ENTER para continuar.%n");
        pressRequest.nextLine();
    }
}

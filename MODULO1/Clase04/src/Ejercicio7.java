import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {
        System.out.printf("%nCÁLCULO DE POTENCIAS.%n");
        System.out.print("Ingresa la base: ");
        int base = reqShow.nextInt();
        System.out.print("Ingresa el exponente: ");
        int exponente = reqShow.nextInt();

        calculatePower(base, exponente);
    }

    private static void calculatePower(int basePo, int exponentePo) {
        int potencia = 1;

        if (exponentePo == 0) {
            System.out.printf("La potencia es de: %d.", potencia);

        }else{
            potencia = basePo;
            for (int i = 1; i < exponentePo; i++) {
                potencia *= basePo;
            }
            System.out.printf("La potencia es de: %d.", potencia);

        }
    }
}

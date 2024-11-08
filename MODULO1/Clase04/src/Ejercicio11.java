import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {
        System.out.printf("%n\tCÁLCULO DE IMC.%n");
        System.out.print("Ingresa tu peso en kilogramos: ");
        float peso = reqShow.nextFloat();
        System.out.print("Ingresa tu altura en metros: ");
        float altura = reqShow.nextFloat();
        
        calculateImc(peso, altura);
    }

    private static void calculateImc(float pesoImc, float alturaImc) {
        float imc = pesoImc / (alturaImc * alturaImc);

        if (imc < 18.5) {
            System.out.printf("Tu IMC es: %.2f%n", imc);
            System.out.print("Bajo de peso.");
        }else if (imc >= 18.5 && imc <= 24.9) {
            System.out.printf("Tu IMC es: %.2f%n", imc);
            System.out.print("Peso normal.");
        }else if (imc >= 25 && imc <= 29.9) {
            System.out.printf("Tu IMC es: %.2f%n", imc);
            System.out.print("Sobrepeso.");
        }else if (imc >= 30 && imc <= 34.9) {
            System.out.printf("Tu IMC es: %.2f%n", imc);
            System.out.print("Obesidad de grado I.");
        }else if (imc >= 35 && imc <= 39.9) {
            System.out.printf("Tu IMC es: %.2f%n", imc);
            System.out.print("Obesidad de grado II.");
        }else if (imc >= 40) {
            System.out.printf("Tu IMC es: %.2f%n", imc);
            System.out.print("Obesidad de grado III.");
        }else{
            System.err.println("Datos ingresados erroneos.");
        }
    }
}

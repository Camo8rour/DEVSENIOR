package Modulo1.Clase03;
import java.util.Random;

public class Ejercicio18 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que genere 120 números aleatorios entre -100 y 100. Imprime los siguientes cálculos:

        Sumar los valores positivos.
        Sumar los valores negativos.
        Calcule la media de los números negativos.
        Calcule la media de los números positivos.
        Cuente la cantidad de ceros.*/

        var aleatorio = new Random();

        int contador = 0;
        int positivos = 0;
        int negativos = 0;
        int contaPo = 0;
        int contaNe = 0;

        System.out.print("Numeros: ");

        for(int i = 0; i < 120; i ++){
            int numAleatorio = aleatorio.nextInt(201) - 100;
            System.out.printf("%s. ", numAleatorio);
            if (numAleatorio == 0) {
                contador ++;
            }else if (numAleatorio < 0) {
                negativos += numAleatorio;
                contaNe ++;
            }else if (numAleatorio > 0) {
                positivos += numAleatorio;
                contaPo ++;
            }
        }

        double mediaPositivos = (contaPo > 0) ? (double) positivos / contaPo : 0;
        double mediaNegativos = (contaNe > 0) ? (double) negativos / contaNe : 0;

        System.out.printf("%n_________________________________________");
        System.out.printf("%nSuma de valores positivos: %d.", positivos);
        System.out.printf("%nSuma de valores negativos: %d.", negativos);
        System.out.printf("%nMedia de los %s números positivos: %.2f.", contaPo, mediaPositivos);
        System.out.printf("%nMedia de los %s números negativos: %.2f.", contaNe, mediaNegativos);
        System.out.printf("%nCantidad de ceros: %d.", contador);
    }
}

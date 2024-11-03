package Modulo1.Clase02;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        /*ENUNCIADO:  Crea un programa que calcule la media aritmética de tres números introducidos por el usuario.*/

        var pedir = new Scanner(System.in);

        System.out.println("Por favor si va ingresar numeros decimales escribalos con coma ','");

        System.out.print("Introduzca el número 1: ");
        double numero1 = pedir.nextDouble();

        System.out.print("Introduzca el número 2: ");
        double numero2 = pedir.nextDouble();

        System.out.print("Introduzca el número 3: ");
        double numero3 = pedir.nextDouble();

        var mediaAritmetica = (numero1 + numero2 + numero3) / 3;

        System.out.printf("La media aritmética de los tres números introducidos es de %.2f.", mediaAritmetica);

        pedir.close();
    }
}

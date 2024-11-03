package Modulo1.Clase02;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        /*ENUNCIADO: Crea un programa que calcule el área y el perímetro de un rectángulo. Solicita al usuario la longitud y el ancho del rectángulo.*/

        var pedir = new Scanner(System.in);

        System.out.println("Por favor si va ingresar numeros decimales escribalos con coma ','");

        System.out.print("Introduzca la longitud del rectángulo en cm: ");
        double longitud = pedir.nextDouble();

        System.out.print("Introduzca el ancho del rectángulo en cm: ");
        double ancho = pedir.nextDouble();

        var area = longitud * ancho;
        var perimetro = 2 * (longitud + ancho);

        System.out.printf("El áres del rectángulo es de %.2f cm^2 y tiene un perímetro de %.2f cm.", area, perimetro);

        pedir.close();
    }
}

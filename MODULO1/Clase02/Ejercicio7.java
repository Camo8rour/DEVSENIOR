package Modulo1.Clase02;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escribe un programa que solicite al usuario dos números y luego realice las operaciones de suma, resta, multiplicación y división con esos números. 
        -Muestra los resultados en la consola. */

        var pedir = new Scanner(System.in);

        System.out.println("Por favor si va ingresar numeros decimales escribalos con coma ','");

        System.out.print("Introduzca el numero 1: ");
        double numero1 = pedir.nextDouble();

        System.out.print("Introduzca el numero 1: ");
        double numero2 = pedir.nextDouble();

        var suma = numero1 + numero2;
        var resta = numero1 - numero2;
        var multiplicacion = numero1 * numero2;
        var division = numero1 / numero2;

        System.out.printf("La suma de los numeros da como resultado: %.2f. %n", suma);
        System.out.printf("La resta de los numeros da como resultado: %.2f. %n", resta);
        System.out.printf("La multiplicación de los numeros da como resultado: %.2f. %n", multiplicacion);
        System.out.printf("La división de los numeros da como resultado: %.2f. %n", division);

        pedir.close();
    }
}

package MODULO1.Clase02;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        /*ENUNCIADO:  Escribe un programa que convierta una temperatura dada en grados Celsius a grados Fahrenheit y Kelvin. 
        
        -Usa las siguientes fórmulas:
        Fahrenheit = Celsius * 9/5 + 32
        Kelvin = Celsius + 273.15*/

        var pedir = new Scanner(System.in);

        System.out.println("Por favor si va ingresar temperaturas con numeros decimales escribalos con coma ',' y no agregue el simbolo de grados.");

        System.out.print("Introduzca la temperatura en grados Celsius: ");
        double gradosCelsius = pedir.nextDouble();

        var gradosFahrenheit = (gradosCelsius * 9/5) + 32;
        var gradosKelvin = gradosCelsius + 273.15d;

        System.out.printf("Los grados Celsius convertidos a grados Fahrenheit da como resultado: %.2f° F. %n", gradosFahrenheit);
        System.out.printf("Los grados Celsius convertidos a grados Kelvin da como resultado: %.2fK.", gradosKelvin);

        pedir.close();
    }
}

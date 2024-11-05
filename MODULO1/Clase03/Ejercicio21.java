package Modulo1.Clase03;
import java.util.Scanner;

public class Ejercicio21 {
    public static void main(String[] args) {
        /*ENUNCIADO: Realizar un programa que permita hacer la siguiente conversión:
        Millas a kilómetros.
        Kilómetros a millas.

        Considera que
        1 milla son 1.60934 kilómetros
        1 kilómetro es 0.621371 millas*/

        var pedir = new Scanner(System.in);

        double millas;
        double kilometros;

        System.out.println("Si desea convertir de kilómetros a millas ingrese la letra 'K' (mayúscula).");
        System.out.println("Si desea convertir de millas a kilómetros ingrese la letra 'M' (mayúscula).");
        System.out.print("-> ");
        char letra = pedir.next().charAt(0);

        if (letra == 'K') {
            System.out.println("Ingrese el número de kilómetros: ");
            kilometros = pedir.nextDouble();

            millas = kilometros * 0.621371;
            System.out.printf("%.2f kilómetros son %f millas.", kilometros, millas);

        }else if (letra == 'M') {
            System.out.println("Ingrese el número de millas: ");
            millas = pedir.nextDouble();

            kilometros = millas * 1.60934;
            System.out.printf("%.2f millas son %f kilómetros.", millas, kilometros);

        }else{
            System.err.println("La letra ingresada es incorrecta.");
        }

        pedir.close();
    }
}

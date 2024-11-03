package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio15 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa en el que ingrese un número y le diga si es positivo o negativo. Repita el proceso hasta que se ingrese el número cero.*/

        var pedir = new Scanner(System.in);

        int numero = 0;

        while (true) {
            System.out.print("Ingrese un número: ");
            numero = pedir.nextInt();

            if(numero == 0) {
                System.out.print("Número cero ingresado, ejecución terminada.");
                break;
            }else if (numero > 0) {
                System.out.println("El número ingresado es positivo.");
            }else{
                System.out.println("El número ingresado es negativo.");
            }

        }

        pedir.close();
    }
}

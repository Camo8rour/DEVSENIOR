package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio23 {
    public static void main(String[] args) {
        /*ENUNCIADO: Realizar un programa que imprima un diamante usando caracteres de texto. 
        El programa debe pedir al usuario el tamaño del diamante, el cual debe ser un número entero positivo impar. Ej:

        Si tamaño es: 3
         *
        ***
         *
        Si tamaño es: 7
           *
          ***
         *****
        *******
         *****
          ***
           *
        Ten en cuenta que la linea de asteriscos (*) de la fila central es la mas grande y debe estar alineada a la parte izquierda de la pantalla 
        y debe tener del tamaño del número dado. El resto de las lineas deben quedar los asteriscos centrados teniendo como base la linea central. 
        En caso de que el número ingresado no sea válido, se le debe informar el usuario el caso que no está cumpliendo.*/


        var pedir = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo impar: ");
        int numero = pedir.nextInt();
        int mitad = numero / 2;

        for (int i = 0; i <= mitad; i++) {

            for (int o = 0; o < mitad - i; o++) {
                System.out.print(" ");
            }

            for (int u = 0; u < 2 * i + 1; u++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = mitad - 1; i >= 0; i--) {

            for (int e = 0; e < mitad - i; e++) {
                System.out.print(" ");
            }

            for (int a = 0; a < 2 * i + 1; a++) {
                System.out.print("*");
            }
            System.out.println();
        }

        pedir.close();
    }
}

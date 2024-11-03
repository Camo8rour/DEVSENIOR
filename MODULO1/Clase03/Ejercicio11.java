package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba una función en la que pueda ingresar tres números enteros y diferentes. Imprima estos valores en orden ascendente.
        Por ejemplo:

        Input : 3 , 100 , 1
        Output : 13100
        Tenga en cuenta que la respuesta es un texto. Los números los puede concatenar.*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int numero1  = pedir.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int numero2 = pedir.nextInt();

        System.out.print("Ingrese el tercer número: ");
        int numero3  = pedir.nextInt();

        if (numero1 <= numero2 && numero1 <= numero3 && numero2 <= numero3) {
            System.out.printf("%s %s %s.", numero1, numero2, numero3);
        }else if (numero1 <= numero2 && numero1 <= numero3 && numero3 <= numero2) {
            System.out.printf("%s %s %s.", numero1, numero3, numero2);
        }else if (numero2 <= numero1 && numero2 <= numero3 && numero1 <= numero3) {
            System.out.printf("%s %s %s.", numero2, numero1, numero3);
        }else if (numero2 <= numero1 && numero2 <= numero3 && numero3 <= numero1) {
            System.out.printf("%s %s %s.", numero2, numero3, numero1);
        }else if (numero3 <= numero1 && numero3 <= numero2 && numero1 <= numero2) {
            System.out.printf("%s %s %s.", numero3, numero1, numero2);
        }else if (numero3 <= numero1 && numero3 <= numero2 && numero2 <= numero1) {
            System.out.printf("%s %s %s.", numero3, numero2, numero1);
        }else{
            System.out.print("Debes ingresar un número entero.");
        }

        pedir.close();
    }
}

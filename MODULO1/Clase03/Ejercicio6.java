package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar un número y determine si es divisible por dos y siete.*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese el número: ");
        short numero  = pedir.nextShort();

        if (numero % 2 == 0 && numero % 7 == 0) {
            System.out.printf("El número %s si es divisible por dos y siete.%n", numero);
        }else{
            System.out.printf("El número %s no es divisible por dos y siete.%n", numero);
        }
        
        pedir.close();
    }
}

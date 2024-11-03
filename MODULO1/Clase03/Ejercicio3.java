package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar un número e identificar si es par o impar.*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese el número: ");
        short numero  = pedir.nextShort();

        if (numero % 2 == 0 ) {
            System.out.print("El número que ingreso es par.");
        }else{
            System.out.print("El número que ingreso es impar.");
        }
        
        pedir.close();
    }
}

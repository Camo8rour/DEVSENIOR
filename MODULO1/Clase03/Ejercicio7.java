package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar tres números (representan la longitud de una línea) y compruebe si con estos números se puede formar un triángulo.*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese el número 1: ");
        short numero1  = pedir.nextShort();

        System.out.print("Ingrese el número 2: ");
        short numero2  = pedir.nextShort();

        System.out.print("Ingrese el número 3: ");
        short numero3  = pedir.nextShort();

        if (numero1 + numero2 > numero3 && numero1 + numero3 > numero2 && numero2 + numero3 > numero1) {
            System.out.print("Con los números ingresados SI se puede formar un triángulo.");
        }else{
            System.out.print("Con los números ingresados NO se puede formar un triángulo.");
        }
        
        pedir.close();
    }
}

package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar un número mientras estos sean negativos. 
        Detener cuando el número ingresado sea positivo y de cómo resultado la cantidad de números negativos ingresados.*/

        var pedir = new Scanner(System.in);

        int numero = 0;
        int contador = 0;

        while (true) {
            System.out.print("Ingrese un número: ");
            numero = pedir.nextInt();

            if(numero > 0) {
                System.out.printf("Cantidad de %s números negativos ingresados.", contador);
                break;
            }else if (numero < 0) {
                contador ++;
            }

        }

        pedir.close();
    }
}

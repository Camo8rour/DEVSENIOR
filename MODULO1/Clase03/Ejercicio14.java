package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        /*ENUNCIADO: Realice un programa en el que ingrese un número y muestre el cubo. Repita el proceso hasta que se introduzca un valor negativo.*/

        var pedir = new Scanner(System.in);

        int numero = 0;

        while (true) {
            System.out.print("Ingrese un número: ");
            numero = pedir.nextInt();

            if(numero < 0) {
                System.out.print("Número negativo ingresado, ejecución terminada.");
                break;
            }else{
                int cubo = 0;

                cubo = numero * numero * numero;
    
                System.out.printf("El cubo de %s es: %s. %n", numero, cubo);
            }

        }

        pedir.close();
    }
}

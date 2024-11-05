package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba una función en la que ingrese un número entero entre 1 y 12. Este número corresponde con un mes (1 enero, 2 febrero, ..., 12 diciembre). 
        El resultado debe ser el número de días del mes ingresado.

        Ejemplo:

        Input : 12
        Output : 31
        A continuación encuentras la cantidad de días que tienen cada mes.

        Mes	Días
        1, 3, 5, 7, 8, 10 y 12	| 31
        4, 6, 9, 11         	| 30
        2	                    |28*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese un número entero entre 1 y 12: ");
        byte mes  = pedir.nextByte();

        String dias = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> "31";
            case 2 -> "29";
            case 4, 6, 9, 11 -> "30";
            default -> "No es válido";
        };

        if (mes >= 1 && mes <= 12) {
            System.out.printf("El mes %s tiene %s días.", mes, dias);
        }else{
            System.out.printf("El mes %s ingresado %s.", mes, dias);
        }

        pedir.close();
    }
}
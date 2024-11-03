package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar un número (va a representar la cantidad de años) 
        y de como respuesta la etapa en la que se encuentra la persona de acuerdo con la tabla.

            | Años | Etapas |
            | :-: | --- |
            | 0 - 5 | Primera infancia |
            | 6 - 11 | Infancia |
            | 12 - 18 | Adolescencia |
            | 19 - 26 | Juventud |
            | 27 - 59 | Adultez |
            |> 59 | Persona mayor |*/
        
        var pedir = new Scanner(System.in);

        System.out.print("Ingrese un número (cantidad en años): ");
        byte edad  = pedir.nextByte();

        if (edad >= 0 && edad <= 5) {
            System.out.print("La etapa en la que se encuentra la persona es de Primera infancia.");
        }else if (edad >= 6 && edad <= 11) {
            System.out.print("La etapa en la que se encuentra la persona es de Infancia.");
        }else if (edad >= 6 && edad <= 11) {
            System.out.print("La etapa en la que se encuentra la persona es de Infancia.");
        }else if (edad >= 12 && edad <= 18) {
            System.out.print("La etapa en la que se encuentra la persona es de Adolescencia.");
        }else if (edad >= 19 && edad <= 26) {
            System.out.print("La etapa en la que se encuentra la persona es de Juventud.");
        }else if (edad >= 27 && edad <= 59) {
            System.out.print("La etapa en la que se encuentra la persona es de Adultez.");
        }else if (edad > 60) {
            System.out.print("La etapa en la que se encuentra la persona es de Persona mayor.");
        }else{
            System.out.print("La edad ingresada no es valida.");
        }
        
        pedir.close();
    }
}

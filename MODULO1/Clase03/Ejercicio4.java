package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar una letra e identifique si la letra es mayúscula o minúscula.*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese una letra: ");
        char letra = pedir.next().charAt(0);

        if (letra >= 'A' && letra <= 'Z') {
            System.out.print("La letra ingresada es mayúscula.");
        } else if (letra >= 'a' && letra <= 'z') {
            System.out.print("La letra ingresada es minúscula.");
        } else {
            System.out.print("El carácter ingresado no es una letra.");
        }
        
        pedir.close();
    }
}
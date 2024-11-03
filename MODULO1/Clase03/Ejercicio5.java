package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar una letra e identifique si es vocal o consonante.*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese una letra: ");
        char letra = pedir.next().charAt(0);

        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'|| letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
            System.out.print("La letra ingresada es una vocal.");
        } else if (letra >= 'a' && letra <= 'z' || letra >= 'A' && letra <= 'Z') {
            System.out.print("La letra ingresada es una consonante.");
        } else {
            System.out.print("El carácter ingresado no es una letra.");
        }
        
        pedir.close();
    }
}

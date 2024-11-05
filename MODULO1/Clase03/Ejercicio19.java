package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio19 {
    public static void main(String[] args) {
        /*ENUNCIADO: Esta sucesión comienza con los números 0 y 1. El siguiente miembro se calcula como la suma de los dos inmediatamente anteriores.
        Crea un programa reciba un número (N) del usuario y muestre los primeros N números de sucesión.*/

        int principal;
        int ultimo = 0;
        int resultado = 1;

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
            int n = pedir.nextInt();

        for(int i = 0; i < n; i++){
            principal = ultimo;
            ultimo = resultado;
            resultado = principal + ultimo;

            System.out.printf("%d. ", principal);
        }

        pedir.close();
    }
}

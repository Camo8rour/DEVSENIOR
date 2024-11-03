package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        /*Un vendedor al por mayor de camisas ofrece diferentes precios de acuerdo a la cantidad de unidades que le compren. La siguiente tabla muestra la información:

        Unidades	|Precio por unidad
        [1 - 50]	|$50.000
        (50 - 100]	|$45.000
        (100 - 150]	|$40.000
        (150 - 200]	|$35.000
        > 200	    |$25.000
        Escriba un programa que dado un número de camisas retorne el precio por unidad.
        */

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de unidades que desea comprar: ");
        short unidad  = pedir.nextShort();

        if (unidad >= 1 && unidad <= 50) {
            System.out.print("El precio por unidad de las camisas es de $50.000.");
        }else if (unidad >= 50 && unidad <= 100) {
            System.out.print("El precio por unidad de las camisas es de $45.000.");
        }else if (unidad >= 100 && unidad <= 150) {
            System.out.print("El precio por unidad de las camisas es de $40.000.");
        }else if (unidad >= 150 && unidad <= 200) {
            System.out.print("El precio por unidad de las camisas es de $35.000.");
        }else if (unidad >= 200) {
            System.out.print("El precio por unidad de las camisas es de $25.000.");
        }else{
            System.out.print("No has ingresado la correcta cantidad de unidades a comprar.");
        }
        
        pedir.close();
    }
}

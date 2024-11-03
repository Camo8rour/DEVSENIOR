package Modulo1.Clase03;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        /*ENUNCIADO: Tres hermanos acuerdan reunirse. Los hermanos son identificados por los siguientes números: 1 para el mayor, 2 para el del medio y 3 para el menor.
        Cuando llega la hora de la reunión, uno de los hermanos va tarde. Dados los números de los hermanos que llegan a tiempo, determine el número del hermano que llegará tarde.
        Por ejemplo:

        Input : 1 2
        Output : 3
        El tercer hermano es el el que llegara a la reunión tarde.*/

        var pedir = new Scanner(System.in);

        System.out.print("Ingrese el primer hermano que llego a tiempo: ");
        short aTiempo1 = pedir.nextByte();

        System.out.print("Ingrese el segundo hermano que llego a tiempo: ");
        byte aTiempo2 = pedir.nextByte();

        if (aTiempo1 == 1 && aTiempo2 == 2 || aTiempo1 == 2 && aTiempo2 == 1) {
            System.out.print("El tercer hermano es el que llegara a la reunión tarde.");
        }else if (aTiempo1 == 3 && aTiempo2 == 1 || aTiempo1 == 1 && aTiempo2 == 3) {
            System.out.print("El segundo hermano es el que llegara a la reunión tarde.");
        }else if (aTiempo1 == 3 && aTiempo2 == 2 || aTiempo1 == 2 && aTiempo2 == 3) {
            System.out.print("El primero hermano es el que llegara a la reunión tarde.");
        }else{
            System.out.print("El número de hermano ingresado no es correcto o se ingreso dos veces el mismo número de hermano.");
        }

        pedir.close();
    }
}

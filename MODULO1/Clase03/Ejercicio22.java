package Modulo1.Clase03;
import java.util.Scanner;

public class Ejercicio22 {
    public static void main(String[] args) {
        /*ENUNCIADO: Realizar un programa que permita controlar el juego de piedra, papel, tijera introduciendo P para piedra, L para papel y T para tijera por cada jugador.
        El sistema debe indicar qué jugador gana la ronda o si hay empate. Al final de cada ronda preguntar si desea volver a jugar.*/
        
        var pedir = new Scanner(System.in);

        int volver;

        do {

            System.out.println("JUGADOR 1");
            System.out.println("Ingrese piedra (P), papel (L) o tigera (T)");
            System.out.print("-> ");
            char jugador1 = pedir.next().charAt(0);

            System.out.println("JUGADOR 2");
            System.out.println("Ingrese piedra (P), papel (L) o tigera (T)");
            System.out.print("-> ");
            char jugador2 = pedir.next().charAt(0);

            pedir.nextLine();

            if (jugador1 == 'P' && jugador2 == 'P' || jugador1 == 'L' && jugador2 == 'L' || jugador1 == 'T' && jugador2 == 'T') {
                System.out.println("Ronda empatada");
            }else if (jugador1 == 'L' && jugador2 == 'P' || jugador1 == 'P' && jugador2 == 'T' || jugador1 == 'T' && jugador2 == 'L') {
                System.out.println("JUGADOR 1 gana la ronda.");
            }else if (jugador1 == 'P' && jugador2 == 'L' || jugador1 == 'T' && jugador2 == 'P' || jugador1 == 'L' && jugador2 == 'T') {
                System.out.println("JUGADOR 2 gana la ronda.");
            }else{
                System.err.println("Las letras ingresadas son incorrectas.");
            }

            System.out.println("Presione 'Enter' para continuar.");
            pedir.nextLine();

            System.out.println("¿Desea volver a jugar?");
            System.out.println("0. Si.");
            System.out.println("1. No.");
            volver = pedir.nextInt();

        } while (volver != 1);

        pedir.close();
    }
}

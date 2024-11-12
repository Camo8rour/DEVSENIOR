import ejercicios.triqui.Triqui;

import java.util.Scanner;

import ejercicios.ahorcado.Ahorcado;
import ejercicios.conecta_4.Conecta_4;


public class App {
    public static void main(String[] args) throws Exception {
        var request = new Scanner(System.in);

        byte menu;

        System.out.println("---------------");
        System.out.println("\t MENÚ");
        System.out.println("---------------");
        System.out.println("1. Jugar tiqui.");
        System.out.println("2. Jugar ahorcado.");
        System.out.println("3. Jugar conecta 4.");
        System.out.println("0. Salir");
        System.out.print("--> ");
        menu = request.nextByte();

        switch (menu) {
            case 1:
                Triqui.startGame();
                break;
            case 2:
                Ahorcado.startGame();
                break;
            case 3:
                Conecta_4.startGame();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.err.println("El valor ingresado es invalido.");
                break;
        }

        request.close();
    }


}

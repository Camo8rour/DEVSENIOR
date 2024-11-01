package MODULO1.Clase01;
import java.util.Scanner;

public class MostrarPalabras {
    public static void main(String[] args) {
        var pedir = new Scanner(System.in);

        System.out.print("Introduzca palabra 1: ");
        String palabra1 = pedir.nextLine();

        System.out.print("Introduzca palabra 2: ");
        String palabra2 = pedir.nextLine();

        System.out.print("Introduzca palabra 3: ");
        String palabra3 = pedir.nextLine();

        System.out.printf("%s %s %s", palabra1, palabra2, palabra3);

        pedir.close();
    }
}

import java.util.Scanner;
import java.text.Normalizer;

public class Ejercicio2 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showString(request);

        request.close();
    }

    private static void showString(Scanner request) {
        System.out.printf("%nVERIFICACIÓN DE PALÍNDROMOS.%n");
        System.out.println("Ingrese una cadena de texto.");
        System.out.print("-> ");
        String text = request.nextLine();
        verificatedString(text);
    }

    private static void verificatedString(String text){
        String textnormalized = Normalizer.normalize(text, Normalizer.Form.NFD)
                                          .replaceAll("[^\\p{ASCII}]", "")
                                          .toLowerCase();

        String textLetters = textnormalized.replaceAll("[^a-z]", "");
        
        String reversedText = new StringBuilder(textLetters).reverse().toString();

        if (textLetters.equalsIgnoreCase(reversedText)) {
            System.out.println("La cadena es un palíndromo");
        }else{
            System.out.println("La cadena no es un palíndromo");
        }
    }
}

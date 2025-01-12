import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        System.out.printf("%nIngrese el texto. %n--> ");
        String text = request.nextLine();

        String[] words = text.toLowerCase().split("\\W+"); //Texto en minúscula y dividido.

        Map<String, Integer> frequency = new HashMap<>(); //Declaración del mapa

        countWord(words, frequency); // Contar frecuencia de las palabras

        showFrequency(frequency); // Mostrar la frecuencia

        request.close();
    }

    private static void countWord(String[] words, Map<String, Integer> frequency) {
        for (String word : words) {
            if (word.isEmpty()) continue;
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
    }

    private static void showFrequency(Map<String, Integer> frequency) {
        System.out.println("\nFrecuencia de las palabras:");
        
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

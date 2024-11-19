package ejercicios.ahorcado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    public static void startGame() {
        var request = new Scanner(System.in);
        var ramdom = new Random();

        var words = List.of("programacion", "java", "computadora", "teclado", "pantalla", "internet", 
        "desarrollo", "software", "hardware", "algoritmo", "variable", "funcion", "clase", "objeto", "herencia", 
        "polimorfismo", "interfaz", "compilador", "debugging", "sintaxis");

        var playAgain = false;
        do {
            var word = words.get(ramdom.nextInt(words.size())).toUpperCase();

            playGame(word, request);

            System.out.print("¿Desea jugar de nuevo? (S/N): ");
            var option = request.nextLine();
            playAgain = !option.equalsIgnoreCase("N");
        } while (playAgain);

        System.out.println("See you later!");

        request.close();
    }

    private static void playGame(String word, Scanner req) {
        var guessed = new ArrayList<Character>();
        var letters = new ArrayList<Character>(word.length());

        for (int i = 0; i < word.length(); i++) {
            letters.add('_');
        }

        var errors = 0;
        var endGame = false;

        while (!endGame) {
            showScreen(letters, guessed, errors);

            System.out.print("Ingrese una nueva letra: ");
            var letter = req.nextLine().toUpperCase().charAt(0);

            if(!Character.isLetter(letter)) {
                System.out.println("Esta letra no válida.");
                req.nextLine();
                continue;
            }

            if(guessed.contains(letter)) {
                System.out.println("Esta letra ya ha sido ingresada anteriormente.");
                req.nextLine();
                continue;
            }

            if (word.indexOf(letter) != -1) {
                guessed.add(letter);

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter) {
                        letters.set(i, letter);
                    }
                }
            }else{
                System.out.println("Los siento, esta letra no esta en la palabra.");
                guessed.add(letter);
                errors++;
            }

            if (guessed.contains(letter)) {
                System.out.println("Letra ingresada");
            }

            if (errors == 6) {
                showScreen(letters, guessed, errors);
                System.out.println("Perdiste!");
                endGame = true;
            }

            if(!letters.contains('_')){
                showScreen(letters, guessed, errors);
                System.out.println("Ganaste!");
                endGame = true;
            }

        }
    }

    private static void showScreen(List<Character> letters, List<Character> guessed, int errors) {
        System.out.print("Palabra a adivinar: ");
        for (var letter: letters) {
            System.out.printf("%c ", letter);
        }
        System.out.println();

        System.out.print("Letras intentadas: ");
        for (var letter: guessed) {
            System.out.printf("%c ", letter);
        }
        System.out.println();

        var draw = switch(errors) {
            case 1 -> """
                       +------+
                       |      |
                       |      O
                       |
                       |
                       |
                       |
                    +--+--+
                    |     |
                    """;
            case 2 -> """
                       +------+
                       |      |
                       |      O
                       |      |
                       |      |
                       |
                       |
                    +--+--+
                    |     |
                    """;
            case 3 -> """
                +------+
                |      |
                |      O
                |     \\|
                |      |
                |
                |
                +--+--+
                |     |
                """;
            case 4 -> """
                +------+
                |      |
                |      O
                |     \\|/
                |      |
                |
                |
                +--+--+
                |     |
                """;
            case 5 -> """
                +------+
                |      |
                |      O
                |     \\|/
                |      |
                |     /
                |
                +--+--+
                |     |
                """;
            case 6 -> """
                +------+
                |      |
                |      O
                |     \\|/
                |      |
                |     / \\
                |
                +--+--+
                |     |
                """;
            default -> """
                       +------+
                       |      |
                       |
                       |
                       |
                       |
                       |
                    +--+--+
                    |     |
                    """;
        };
        System.out.println(draw);
    }
}

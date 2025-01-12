import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        List <Integer> numbers = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        List <Integer> numbersUnique = new ArrayList<>();

        enterNumbers(request, numbers, count);

        filterUniqueNumbers(count, numbersUnique);

        showNumbers(numbersUnique);

        request.close();
    }

    //Ingresar números y tomar ocurrencias.
    private static void enterNumbers(Scanner request, List <Integer> numbers, Map<Integer, Integer> count) {
        System.out.printf("%nIngrése los números, para finalizar escriba '99999'.%n");

        while (true) {
            System.out.printf("--> ");
            int number = request.nextInt();

            if(number == 99999){
                break;
            }

            numbers.add(number);
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
    }

    // Filtrar números.
    private static void filterUniqueNumbers(Map<Integer, Integer> count, List <Integer> numbersUnique){
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                numbersUnique.add(entry.getKey());
            }
        }
    }

    //Mostrar números unicos.
    private static void showNumbers(List<Integer> numberUnique) {
        System.out.println("\nLos números unicos ingresados son:");
        for (int number : numberUnique) {
            System.out.println(number);
        }
    }
}

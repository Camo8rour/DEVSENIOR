import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Queue<String> documents = new LinkedList<>();

        var request = new Scanner(System.in);

        enterDocuments(documents, request); //Documentos a ingresar.

        documentPrinting(documents); //Documento imprimiendo.

        documentsQueue(documents); //Documentos en cola.

        request.close();
    }

    private static void enterDocuments(Queue<String> documents, Scanner request) {
        System.out.printf("%nIngrése los documentos que desee imprimir. %nPara finalizar escriba 'IMPRIMIR'.%n");

        while (true) {
            System.out.printf("--> ");
            String document = request.nextLine();

            if (document.equalsIgnoreCase("IMPRIMIR")) {
                break;
            }

            documents.offer(document);
        }
    }

    private static void documentPrinting(Queue<String> documents) {
        if (!documents.isEmpty()) {
            String printing = documents.poll();
            System.out.printf("%nDocumento imprimiendo: %s.%n", printing);
        } else {
            System.out.printf("%nNo hay documentos para imprimir.%n");
        }
    }

    private static void documentsQueue(Queue<String> documents) {
        if (!documents.isEmpty()) {
            System.out.printf("%nDocumentos en cola:");
            for (String document : documents) {
                System.out.printf("%n-%s.", document);
            }
        } else {
            System.out.printf("%nNo hay documentos en cola.%n");
        }
    }
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio4 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        Set<String> mails = new HashSet<>();

        enterMails(request, mails);

        showMails(mails);

        request.close();
    }

    //Ingresar correos.
    private static void enterMails(Scanner request, Set<String> mails) {
        System.out.printf("%nIngrése los correos electronicos, para finalizar escriba 'STOP'.%n");

        while (true) {
            System.out.printf("--> ");
            String mail = request.nextLine();

            if(mail.equalsIgnoreCase("STOP")){
                break;
            }

            if (mails.contains(mail)) {
                System.out.printf("%n¡Correo electrónico duplicado!.%nEl correo '%s' ya ha sido ingresado anteriormente.%nIntentelo nuevamente.%n%n", mail);
            } else {
                mails.add(mail);
            }
        }
    }

    //Mostrar correos.
    private static void showMails(Set<String> mails) {
        System.out.println("\nCorreos electrónicos ingresados:");
        for (String mail : mails) {
            System.out.println(mail);
        }
    }
}

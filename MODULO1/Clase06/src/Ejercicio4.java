import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showId(request);
        System.out.println("Gracias por utilizar el programa.");

        request.close();
    }

    private static void showId(Scanner request) {

        System.out.printf("%nIngrese cuantos UID desea validar: ");
        int num = request.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.printf("Ingrese el UID %d: ", i + 1);
            String uid = request.next();
            validateId(uid);
        }
    }

    private static void validateId(String uid) {
        boolean validate = true;
        int capitalCount = 0;
        int digitCount = 0;

        //Valida que deba contener por lo menos dos letras mayúsculas en el alfabeto inglés.
        for (char character : uid.toCharArray()) {
            if (Character.isUpperCase(character)) {
                capitalCount ++;
            }
        }
        if (capitalCount < 2) {
            validate = false;
        }

        //Valida que debatener por lo menos 3 dígitos.
        for (char character : uid.toCharArray()) {
            if (Character.isDigit(character)) {
                digitCount ++;
            }
        }
        if (digitCount < 3) {
            validate = false;
        }

        //Valida que deba contener únicamente dígitos alfanuméricos.
        if (!uid.matches("[a-zA-Z0-9]+")) {
            validate = false;
        }

        //Valida que no deba tener repeticiones.
        if (uid.length() != uid.chars().distinct().count()) {
            validate = false;
        }

        //Valida que deba contener exactamente 10 caracteres.
        if (uid.length() != 10) {
            validate = false;
        }

        if (validate == true) {
            System.out.printf("El UID %s es válido.%n%n", uid);
        }else{
            System.out.printf("El UID %s no es válido.%n%n", uid);
        }
    }
}

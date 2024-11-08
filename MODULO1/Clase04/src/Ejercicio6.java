import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {
        byte option;

        do {
            System.out.printf("%n-----------------------------------------------------%n");
            System.out.println("\t \t MENÚ DE OPCIONES");
            System.out.println("-----------------------------------------------------");
            System.out.println("1. Conversión de unidades de metros a kilometros.");
            System.out.println("2. Conversión de unidades de kilometros a metros.");
            System.out.println("3. Conversión de unidades de gramos a kilogramos.");
            System.out.println("4. Conversión de unidades de kilogramos a gramos.");
            
            System.out.println("0. Salir del programa.");
            System.out.print("-> ");
            option = reqShow.nextByte();
            reqShow.nextLine();

            switch (option) {
                case 0:
                    break;

                case 1:
                    calculateKilometros(reqShow);
                    break;

                case 2:
                    calculateMetros(reqShow);
                    break;

                case 3:
                    calculateKilogramos(reqShow);
                    break;

                case 4:
                    calculateGramos(reqShow);
                    break;

                default:
                    System.err.println("Ingrese una opción valida.");
                    break;
            }

            if (option != 0) {
                pressEnter(reqShow);
            }

        } while (option != 0);
    }

    private static void calculateKilometros(Scanner reqKilometros) {
        System.out.print("Ingrese la longitud en metros: ");
        double metros = reqKilometros.nextDouble();
        reqKilometros.nextLine();

        double calculateKm = metros / 1000;
        System.out.printf("La longitud es de %.3f kilometros.", calculateKm);
    }

    private static void calculateMetros(Scanner reqMetros) {
        System.out.print("Ingrese la longitud en kilometros: ");
        double kilometros = reqMetros.nextDouble();
        reqMetros.nextLine();

        double calculateMt = kilometros * 1000;
        System.out.printf("La longitud es de %.0f metros.", calculateMt);
    }

    private static void calculateKilogramos(Scanner reqKilogramos) {
        System.out.print("Ingrese la masa en gramos: ");
        double gramos = reqKilogramos.nextDouble();
        reqKilogramos.nextLine();

        double calculateKg = gramos / 1000;
        System.out.printf("La masa es de %.3f kilogramos.", calculateKg);
    }

    private static void calculateGramos(Scanner reqGramos) {
        System.out.print("Ingrese la masa en kilogramos: ");
        double kilogramos = reqGramos.nextDouble();
        reqGramos.nextLine();

        double calculateMg = kilogramos * 1000;
        System.out.printf("La masa es de %.0f gramos.", calculateMg);
    }

    private static void pressEnter(Scanner request){
        System.out.printf("%nOprima ENTER para continuar.%n");
        request.nextLine();
    }
}

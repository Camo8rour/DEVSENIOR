import java.util.Scanner;

public class Ejercicio8 {
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
            System.out.println("1. Calcular área de un círculo.");
            System.out.println("2. Calcular área de un cuadrado.");
            System.out.println("3. Calcular área de un triángulo.");
            System.out.println("0. Salir del programa.");
            System.out.print("-> ");
            option = reqShow.nextByte();
            reqShow.nextLine();

            switch (option) {
                case 0:
                    break;

                case 1:
                    System.out.print("Ingresa el radio: ");
                    double radio = reqShow.nextDouble();

                    areaCirculo(radio);
                    reqShow.nextLine();
                    break;

                case 2:
                    System.out.print("Ingresa la longitud del lado: ");
                    double lado = reqShow.nextDouble();

                    areaCuadrado(lado);
                    reqShow.nextLine();
                    break;

                case 3:
                    System.out.print("Ingresa la base: ");
                    double base = reqShow.nextDouble();
                    System.out.print("Ingresa la altura: ");
                    double altura = reqShow.nextDouble();

                    areaTriangulo(base, altura);
                    reqShow.nextLine();
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

    private static void areaCirculo(double radioCi){
        double areaCi = Math.PI * (radioCi * radioCi);
        System.out.printf("Área del círculo: %f", areaCi);
    }

    private static void areaCuadrado(double ladoCu){
        double areaCu = ladoCu * ladoCu;
        System.out.printf("Área del cuadrado: %.2f", areaCu);
    }

    private static void areaTriangulo(double baseTri, double alturaTri){
        double areaTri = (baseTri * alturaTri)/2;
        System.out.printf("Área del triángulo: %.2f", areaTri);
    }

    private static void pressEnter(Scanner reqPress){
        System.out.printf("%nOprima ENTER para continuar.%n");
        reqPress.nextLine();
    }
}

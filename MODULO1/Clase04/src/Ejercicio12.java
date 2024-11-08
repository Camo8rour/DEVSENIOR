import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        var request = new Scanner(System.in);

        showInput(request);

        request.close();
    }

    private static void showInput(Scanner reqShow) {
        byte option;
        
        do {
            System.out.println("\n\tCONVERSION DE SEGUNDOS");
            System.out.println("1. Conversión de segundos usando el modo difícil y extenso.");
            System.out.println("2. Conversión de segundos usando el modo fácil y practico.");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            option = reqShow.nextByte();
            reqShow.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingresa la cantidad de segundos: ");
                    int seconds = reqShow.nextInt();
                    conversion1(seconds);
                    reqShow.nextLine();
                    break;
                case 2:
                    System.out.print("Ingresa la cantidad de segundos: ");
                    seconds = reqShow.nextInt();
                    conversion2(seconds);
                    reqShow.nextLine();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Número inválido. Por favor, elige una opción válida.");
                    break;
            }

            if (option != 0) {
                pressEnter(reqShow);
            }

        } while (option != 0);
        
    }

    //MODO DIFÍCIL
    private static void conversion1(int conver1Seconds) {
        int day = 86400;
        int hourse = 3600;
        int minute = 60;
        int contSeconds = conver1Seconds;
        int reDay = 0;
        int reHourse = 0;
        int reMinutes = 0;
        int reSeconds = 0;

        while (true) {
            if(contSeconds % day >= 0) {
                reDay = contSeconds / day;
                contSeconds %= day;

                if (contSeconds % hourse >= 0) {
                    reHourse = contSeconds / hourse;
                    contSeconds %= hourse;

                    if (contSeconds % minute >= 0) {
                        reMinutes = contSeconds / minute;
                        contSeconds %= minute;

                        if (contSeconds >= 0) {
                            reSeconds = contSeconds;
                        }

                    }else{
                        reSeconds = contSeconds;
                    }

                }else{
                    if (contSeconds % minute >= 0) {
                        reMinutes = contSeconds / minute;
                        contSeconds %= minute;

                        if (contSeconds >= 0) {
                            reSeconds = contSeconds;
                        }

                    }else{
                        reSeconds = contSeconds;
                    }
                }
                break;

            } else if (contSeconds % hourse >= 0) {
                reHourse = contSeconds / hourse;
                contSeconds %= hourse;

                if (contSeconds % minute >= 0) {
                    reMinutes = contSeconds / minute;
                    contSeconds %= minute;

                    if (contSeconds >= 0) {
                        reSeconds = contSeconds;
                    }

                }else{
                    reSeconds = contSeconds;
                }
                break;

            }else{
                if (contSeconds % minute >= 0) {
                    reMinutes = contSeconds / minute;
                    contSeconds %= minute;

                    if (contSeconds >= 0) {
                        reSeconds = contSeconds;
                    }

                }else{
                    reSeconds = contSeconds;
                }
                break;
            }
        }

        System.out.printf("Días: %d.%n", reDay);
        System.out.printf("Horas: %d.%n", reHourse);
        System.out.printf("Minutos: %d.%n", reMinutes);
        System.out.printf("Segundos: %d.", reSeconds);
    }

    //MODO FÁCIL
    private static void conversion2(int conver2Seconds) {
        int days = conver2Seconds / 86400;
        int hours = (conver2Seconds % 86400) / 3600;
        int minutes = (conver2Seconds % 3600) / 60;
        int seconds = conver2Seconds % 60;

        System.out.printf("Días: %d.%n", days);
        System.out.printf("Horas: %d.%n", hours);
        System.out.printf("Minutos: %d.%n", minutes);
        System.out.printf("Segundos: %d.%n", seconds);
    }

    private static void pressEnter(Scanner reqPress){
        System.out.printf("%nOprima ENTER para continuar.%n");
        reqPress.nextLine();
    }
}

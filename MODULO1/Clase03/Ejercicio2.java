package Modulo1.Clase03;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que le permita ingresar tres números e imprima en la consola el más grande de ellos.*/

        var pedir = new Scanner(System.in);

        System.out.println("Utilice las coma (,) para los números decimales.");
        System.out.print("Ingrese el número 1: ");
        double numero1 = pedir.nextDouble();

        System.out.print("Ingrese el número 2: ");
        double numero2 = pedir.nextDouble();

        System.out.print("Ingrese el número 3: ");
        double numero3 = pedir.nextDouble();

        if (numero1 >= numero2 && numero1 >= numero3) {
            System.out.printf("El número mayor es %.1f.%n", numero1);
        }else if (numero2 >= numero1 && numero2 >= numero3){
            System.out.printf("El número mayor es %.1f.%n", numero2);
        }else{
            System.out.printf("El número mayor es %.1f.%n", numero3);
        }
        
        pedir.close();
    }
}

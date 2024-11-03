package Modulo1.Clase03;
import java.util.Scanner;

public class Ejercicio1{
    public static void main(String[] args) {
        /*ENUNCIADO: Escriba un programa que permita ingresar un número real e identifique si el número es negativo, positivo o cero.*/

        var pedir = new Scanner(System.in);

        System.out.println("Utilice las coma (,) para los números decimales.");
        System.out.print("Ingrese un número real: ");
        double numero = pedir.nextDouble();

        if (numero == 0) {
            System.out.print("El número que ingreso es 0.");
        }else if (numero >= 0) {
            System.out.print("El número ingresado es positivo.");
        }else{
            System.out.print("El número ingresado es negativo.");
        }
        
        pedir.close();
    }
}
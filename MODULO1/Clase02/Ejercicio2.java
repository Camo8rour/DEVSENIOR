package MODULO1.Clase02;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        
        /*ENUNCIADO: En el mercado, podemos encontrar que el precio del producto Pernil Iberic D'Engreix Llen. Azuaga en porción de 100 gramos cuesta 5,95€ y el vendedor nos dice que el precio por kilo cuesta 29,75€. 
        
        -¿Crees que es correcto el precio?
        No, ya que 1 kilo equivale a 1000 gramos entonces si hacemos regla de tres teniendo en cuenta el precio por gramos nos da como resultado que 1000 gramos equivale a 59,5€.
        */

        var precioGramos = 5.95d;
        var precioKilo = precioGramos * 10;

        System.out.printf("(Teniendo en cuenta el precio por 100 gramos es de %.2f euros) Podemos calcular que el kilo de pernil cuesta %.2f euros. %n", precioGramos, precioKilo);

        //-En este reto tienes que hacer un programa que calcule correctamente el precio por kilo del producto.
        var recibirPantalla = new Scanner(System.in);

        System.out.print("Ingrese el peso del pernil en kilos (si no es exacto separelo con una coma ','): ");
        var peso = recibirPantalla.nextDouble();

        double precio = peso * precioKilo;

        System.out.printf("El precio de los %.2f kilos del pernil es de: %.2f euros. %n", peso, precio);
        
        recibirPantalla.close();
    }
}

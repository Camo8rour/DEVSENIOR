package Modulo1.Clase02;

public class Ejercicio6 {
    public static void main(String[] args) {
        /*ENUNCIADO: En España, las rebajas de invierno suelen comenzar entre los días 1 y 7 de enero y finalizan a final de marzo. 
        Por otro lado, las rebajas de verano empiezan durante la primera semana del mes de julio y finalizan durante el mes de septiembre.
        Para aprovechar la temporada de rebajas he salido de compras. He pagado 34€ por unos pantalones que tenían un descuento del 15%. 
        
        -¿Qué precio tenían antes de aplicar el descuento? */

        var pantalonDescuento = 34d;
        var descuento = 1 - 0.15; //Teniendo en cuenta que el 100% se refleja como 1 y el 15% como 0.15
        var pantalonTotal = pantalonDescuento / descuento;

        System.out.printf("El pantalon antes que aplicara el descuento tenia un precio de %.2f euros.", pantalonTotal);

        //40€ 
    }
}

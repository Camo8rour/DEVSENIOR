package MODULO1.Clase02;

public class Ejercicio5 {
    public static void main(String[] args) {
        /*ENUNCIADO: El videojuego en el ordenador está viviendo una nueva época de oro con un montón de juegos exclusivos. 
        Para comprarte un PC Gamer deberás fijarte principalmente en el procesador, la tarjeta gráfica, la memoria RAM... pero sobre todo en los accesorios como el teclado y ratón.
        Estás interesado en comprarte un nuevo PC y en la tienda de tu barrio cuesta 660€ con todos los accesorios incluidos. Sin embargo, el vendedor te descuenta el 10% por pronto pago.
        
        -¿Cuánto tienes que pagar en total por el ordenador con todos los accesorios?*/

        var valorComputador = 660d;
        var descuento = valorComputador * 0.1;
        var valorTotal = valorComputador - descuento;

        System.out.printf("Tengo que pagar por el ordenador con todos los accesorios %.2f euros.", valorTotal);

        //594€
    }
}

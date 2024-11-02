package MODULO1.Clase02;
public class Ejercicio1 {
    public static void main(String[] args) {
        //ENUNCIADO: El orden de los operadores aritméticos es muy importante ya que dependiendo del orden obtenemos un resultado u otro. En programación, el orden de los operadores es el mismo que el utilizado en matemáticas.
        
        
        //-En este reto deberás programar la operación matemática "6 / 2 ( 1 + 2 )" utilizando las instrucciones necesarias.

        //Para ello vamos a tomar la operación en una variable y la ejecutamos. 
        int calculadoraCorrecta = 6/2*(1+2);
        System.out.printf("La calculadora correcta da como respuesta: %s%n", calculadoraCorrecta);

        //Sabiendo que la calculadora correcta es la del celular ya que da como respuesta 9.
        //Ahora tomamos vamos a hallar la operación para que una calculadora de como resultado 1.

        int calculadoraIncorrecta = 6/(2*(1+2));
        System.out.printf("La operación para que la calculadora normal sea correcta debes ser 6/(2*(1+2)), ya que da como resultado: %s", calculadoraIncorrecta);

        /*-¿Cuál es el resultado correcto de la operación? ¿1 ó 9?

        Cuando observe este ejercicio me puse a hacerlo mentalmente, donde resolvi lo que estaba entre el parentecis primero, seguido de la multiplicación y división, por lo que obtuve como resultado 1. 
        La cual mi error fue no trabajar de izquierda a derecha estas operaciones de igual prioridad, viendo esta forma en que se trabaja me di cuenta que el resultado no era 1 sino 9.

        -Explique por que la otra calculadora genera un resultado diferente.

        Si observamos podemos ver que es una cuestión de parencis por lo que podemos concluir que genera un resultado diferente debido a que esta parametrizada con prioridades diferentes,
        a la hora de trabajar con operaciónes.
        */
    }
}
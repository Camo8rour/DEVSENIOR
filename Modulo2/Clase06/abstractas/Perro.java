package Clase06.abstractas;

public class Perro extends Animal {

    @Override
    void hacerSonido() {
        System.out.println("Ladrar!!!");
    }

    void rascarse() {
        System.out.println("rascarse");
    }

}

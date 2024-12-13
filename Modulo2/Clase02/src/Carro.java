public class Carro extends Vehiculo{
    private int numPuertas;

    //Constructor con parametros de la clase Carro junto con la clase Vehiculo (papá)
    public Carro(String marca, String modelo, int velocidadMaxima, int numPuertas) {
        super(marca, modelo, velocidadMaxima);
        this.numPuertas = numPuertas;
    }

    //Metodos get y set para acceder al número de puertas
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    //Sobrescribe @Override de la clase Vehiculo (papá)
    @Override
    public String toString() {
        return super.toString() + "[Número de puertas = " + numPuertas + ", Tipo = Carro]";
    }
}

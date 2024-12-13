public class Moto extends Vehiculo{
    private String tieneSidecar;

    //Constructor con parametros de la clase Moto junto con la clase Vehiculo (papá)
    public Moto(String marca, String modelo, int velocidadMaxima, String tieneSidecar) {
        super(marca, modelo, velocidadMaxima);
        this.tieneSidecar = tieneSidecar;
    }

    //Metodos get y set para acceder si tiene Sidecar
    public String getTieneSidecar() {
        return tieneSidecar;
    }

    public void setTieneSidecar(String tieneSidecar) {
        this.tieneSidecar = tieneSidecar;
    }

    //Sobrescribe @Override de la clase Vehiculo (papá)
    @Override
    public String toString() {
        return super.toString() + "[¿Tiene Sidecar? = " + tieneSidecar + ", Tipo = Moto]";
    }

}

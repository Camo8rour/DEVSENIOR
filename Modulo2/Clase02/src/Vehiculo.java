public class Vehiculo {
    private String marca;
    private String modelo;
    private int velocidadMaxima;

    // Constructor con parámetros
    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    // Metodos get y set para acceder a la marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Metodos get y set para acceder al modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //Metodos get y set para acceder a la velocidad maxima
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public static void mostrarDetalles() {
        System.out.printf("%n\t \t \t \t \t DETALES DE LOS VEHICULOS%n");
    }

    //Estado del objeto
    @Override
    public String toString() {
        return "Vehiculo [Marca = " + marca + ", Modelo = " + modelo + ", Velocidad maxima = " + velocidadMaxima + "]";
    }

    //Identificador unico
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + velocidadMaxima;
        return result;
    }

    //Comparación de objetos
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (velocidadMaxima != other.velocidadMaxima)
            return false;
        return true;
    }

    

}

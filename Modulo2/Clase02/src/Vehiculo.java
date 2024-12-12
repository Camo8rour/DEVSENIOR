public class Vehiculo {
    String marca;
    String modelo;
    float velocidadMaxima;

    // Constructor con parámetros
    public Vehiculo(String marca, String modelo, float velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    // Método para mostrar detalles del estudiante
    public void mostrarDetalles() {
        System.out.printf("Marca: %s.%n", marca);
        System.out.printf("Modelo: %d.%n", modelo);
        System.out.printf("Velocidad máxima: %.2f.%n", velocidadMaxima);
    }
}

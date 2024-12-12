public class Student { 
    String name;
    int age;
    float average;

    // Constructor con parámetros
    public Student(String name, int age, float average) {
        this.name = name;
        this.age = age;
        this.average = average;
    }

    // Método para mostrar detalles del estudiante
    public void mostrarDetalles() {
        System.out.printf("Nombre: %s.%n", name);
        System.out.printf("Edad: %d.%n", age);
        System.out.printf("Promedio: %.2f.%n", average);
    }

    // Método para verificar si está aprobado
    public boolean esAprobado() {
        return average >= 3.0;
    }
}

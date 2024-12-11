public class Student { 
    String name;
    int age;
    float average;

    // Constructor por defecto
    public Student() {
        name = "N/A";
        age = 0;
        average = 0;
    }

    // Constructor con parámetros
    public Student(String name, int age, float average) {
        this.name = name;
        this.age = age;
        this.average = average;
    }

    // Método para mostrar detalles del estudiante
    public void mostrarDetalles() {
        System.out.println("Nombre: " + name);
        System.out.println("Edad: " + age);
        System.out.println("Promedio: " + average);
    }

    // Método para verificar si está aprobado
    public boolean esAprobado() {
        return average >= 3.0;
    }
}

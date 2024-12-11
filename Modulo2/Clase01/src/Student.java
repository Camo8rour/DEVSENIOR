public class Student {

    String name;
    int age;
    float average;

    public Student(){
        name = "N/A";
        age = 0;
        average = 0;
    }

    public Student(String name, int age, float average){
        this.name = name;
        this.age = age;
        this.average = average;
    }

    public  void mostrarDetalles(){
        System.out.printf("Nombre: " + name);
        System.out.printf("Edad: " + age);
        System.out.printf("Promedio: " + average);
    }

    public boolean esAprobado() {
        return average >= 3.0;
    }

}

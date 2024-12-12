public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Vehiculo carro1 = new Vehiculo("Toyota", "r 2015", 200.0f);
        Vehiculo carro2 = new Vehiculo("Audi", "b 2012", 168.0f);
        Vehiculo moto1 = new Vehiculo("Honda", "xtz 250", 100.0f);
        Vehiculo moto2 = new Vehiculo("Susuki", "gn 125", 95.0f);

        // System.out.printf("%n*****DETALLES DE LOS VEHÍCULOS*****%n");
        // for (Vehiculo student : students) {
        //     student.mostrarDetalles();
        //     System.out.println("¿Está aprobado?: " + (student.esAprobado() ? "Sí" : "No"));
        //     System.out.println();
        // }

    }


}
public class Main {
    public static void main(String[] args) throws Exception {

        Carro carro1 = new Carro("Toyota", "Supra GR", 250, 2);
        Carro carro2 = new Carro("Tesla", "Model S Plaid", 322, 4);
        Carro carro3 = new Carro("Chevrolet", "Camaro ZL1", 318, 2);
        Moto moto1 = new Moto("Kawasaki", "Ninja H2", 400, "No");
        Moto moto2 = new Moto("Royal Enfield", "Classic 350", 120, "Opcional");
        Moto moto3 = new Moto("Ural", "Gear Up", 120, "Si");

        Vehiculo.mostrarDetalles();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(carro1.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(carro2.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(carro3.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(moto1.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(moto2.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(moto3.toString());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }


}
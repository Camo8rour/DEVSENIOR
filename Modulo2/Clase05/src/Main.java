public class Main {
    public static void main(String[] args) throws Exception {
        Cocina cocina = new Cocina();
        Mesero mesero = new Mesero();
        Caja caja = new Caja();

        Restaurante restaurante1 = new Restaurante(cocina, mesero, caja);
        restaurante1.operarRestaurante();
    }
}

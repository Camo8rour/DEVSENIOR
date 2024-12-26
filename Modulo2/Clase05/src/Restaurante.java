public class Restaurante {
    private Cocina cocina;
    private Mesero mesero;
    private Caja caja;

    public Restaurante() {
        this.cocina = new Cocina();
        this.mesero = new Mesero();
        this.caja = new Caja();
    }

    public void operarRestaurante() {
        cocina.prepararPlato();
        mesero.servir();
        caja.procesarPago();
    }

    public Cocina getCocina() {
        return cocina;
    }

    public void setCocina(Cocina cocina) {
        this.cocina = cocina;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

}

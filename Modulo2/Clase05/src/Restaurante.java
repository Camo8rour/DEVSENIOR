public class Restaurante {
    private Cocina cocina;
    private Mesero mesero;
    private Caja caja;

    public Restaurante(Cocina cocina, Mesero mesero, Caja caja) {
        this.cocina = cocina;
        this.mesero = mesero;
        this.caja = caja;
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

    public void operarRestaurante() {
        cocina.prepararPlato();
        mesero.servir();
        caja.procesarPago();
    }
}

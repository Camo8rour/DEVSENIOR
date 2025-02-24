package Clase06.RetoBase;

public class Accidente extends Emergencia implements Responder {

    public Accidente(String tipo, String ubicacion, int nivelGravedad, int tiempoRespuesta) {
        super(tipo, ubicacion, nivelGravedad, tiempoRespuesta);
    }

    @Override
    public void atenderEmergencia() {
        System.out.println("Paramedicos en camino!!!");
    }

    @Override
    public void evaluarEstado() {
        System.out.println("Revisar signos vitales de los involucrados");
    }
}

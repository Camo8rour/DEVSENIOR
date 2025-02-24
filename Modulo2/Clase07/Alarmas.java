package Clase_07;

public class Alarmas {

    private String codigo;

    public Alarmas(String newCodigo) {
        codigo = newCodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public class SensorHumo {
        private String serial;
        private String ubicacion;

        public SensorHumo(String serial, String ubicacion) {
            this.serial = serial;
            this.ubicacion = ubicacion;
        }

        public void detectarHumo() {
            System.out.println("Humo detectado!: " + serial + " " + ubicacion);
        }

        public void lanzarAlerta() {
            System.out.println("Alerta!!! " + serial + " " + ubicacion);
        }

    }

}

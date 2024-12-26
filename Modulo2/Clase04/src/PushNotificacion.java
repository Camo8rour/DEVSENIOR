public class PushNotificacion implements Notificacion {

    @Override
    public void enviar(String mensaje) {
        System.out.printf("%nEnviando notificación push: %s", mensaje);
    }

}

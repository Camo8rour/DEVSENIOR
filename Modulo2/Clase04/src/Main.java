public class Main {
    public static void main(String[] args) throws Exception {
        Notificacion notificacion1 = NotificacionFactory.getNotificacion(TipoNotificacion.CORREO);
        notificacion1.enviar();
        Notificacion notificacion2 = NotificacionFactory.getNotificacion(TipoNotificacion.SMS);
        notificacion2.enviar();
        Notificacion notificacion3 = NotificacionFactory.getNotificacion(TipoNotificacion.PUSH);
        notificacion3.enviar();
    }
}

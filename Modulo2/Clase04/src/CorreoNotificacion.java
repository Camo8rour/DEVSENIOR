public class CorreoNotificacion implements Notificacion {

    @Override
    public void enviar() {
        System.out.printf("%nEnviando correo: [mensaje]");
    }

}

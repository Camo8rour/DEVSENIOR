public class SMSNotificacion implements Notificacion {

    @Override
    public void enviar() {
        System.out.printf("%nEnviando SMS: [mensaje]");
    }

}

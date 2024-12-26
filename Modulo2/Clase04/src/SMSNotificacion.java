public class SMSNotificacion implements Notificacion {

    @Override
    public void enviar(String mensaje){
        System.out.printf("%nEnviando SMS: %s", mensaje);
    }

}

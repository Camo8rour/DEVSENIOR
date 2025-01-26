import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

public class GestionReservas {
    private Map<String, String> reservas = new HashMap<>();
    private GestionClientes gestionClientes;

    public GestionReservas(GestionClientes gestionClientes) {
        this.gestionClientes = gestionClientes;
    }

    public void crearReserva(String clienteId, String fechaInicio, String fechaFin) throws ReservaInvalidaException {
        try {
            gestionClientes.buscarCliente(clienteId);
        } catch (ClienteNoEncontradoException e) {
            throw new ReservaInvalidaException("No se puede crear la reserva. " + e.getMessage());
        }

        if (!esFechaValida(fechaInicio, fechaFin)) {
            throw new ReservaInvalidaException("Las fechas de la reserva no son válidas.");
        }

        reservas.put(clienteId + "-" + fechaInicio, fechaFin);
        System.out.println("Reserva creada para el cliente " + clienteId + " desde " + fechaInicio + " hasta " + fechaFin);
    }

    private boolean esFechaValida(String fechaInicio, String fechaFin) {
        try {
            LocalDate fechaInicioDate = LocalDate.parse(fechaInicio, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate fechaFinDate = LocalDate.parse(fechaFin, DateTimeFormatter.ISO_LOCAL_DATE);
            return fechaInicioDate.isBefore(fechaFinDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public String buscarReserva(String clienteId, String fechaInicio) throws ClienteNoEncontradoException {
        try {
            gestionClientes.buscarCliente(clienteId);
        }catch(ClienteNoEncontradoException e){
            throw new ClienteNoEncontradoException("Cliente con ID " + clienteId + " no encontrado");
        }

        String key = clienteId + "-" + fechaInicio;
        if (reservas.containsKey(key)) {
            return "Reserva encontrada: Cliente " + clienteId + " desde " + fechaInicio + " hasta " + reservas.get(key);
        }else{
            return "No se encontró reserva para el cliente " + clienteId + " en la fecha " + fechaInicio;
        }
    }

}

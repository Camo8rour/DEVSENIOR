import java.util.HashMap;
import java.util.Map;

public class GestionClientes {
    private Map<String, String> clientes = new HashMap<>();

    public void registrarCliente(String id, String nombre) {
        if (clientes.containsKey(id)) {
            System.out.println("El cliente con ID " + id + " ya está registrado.");
        } else {
            clientes.put(id, nombre);
            System.out.println("Cliente registrado con éxito: " + nombre);
        }
    }

    public String buscarCliente(String id) throws ClienteNoEncontradoException {
        if (!clientes.containsKey(id)) {
            throw new ClienteNoEncontradoException("El cliente con ID " + id + " no existe.");
        }
        return clientes.get(id);
    }
}

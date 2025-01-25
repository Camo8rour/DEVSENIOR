import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map <String, Integer> inventario = new HashMap<>();

    public void agregarProducto(String nombre, Integer cantidad) {
        inventario.put(nombre, cantidad);
    }

    public void eliminarProducto(String nombre) throws ProductoNoEncontradoException    {
        if (!inventario.containsKey(nombre)){
            throw new ProductoNoEncontradoException("El producto " + nombre + " no existe en el inventario.");
        }
        inventario.remove(nombre);
    }

    public Integer buscarProducto(String nombre) throws ProductoNoEncontradoException{
        if (!inventario.containsKey(nombre)){
            throw new ProductoNoEncontradoException("El producto " + nombre + " no existe en el inventario.");
        }
        return inventario.get(nombre);
    }

    public void actualizarCantidad(String nombre, int nuevaCantidad) throws ProductoNoEncontradoException, CantidadInvalidaException{
        if (!inventario.containsKey(nombre)){
            throw new ProductoNoEncontradoException("El producto " + nombre + " no existe en el inventario.");
        }else if (nuevaCantidad < 0){
            throw new CantidadInvalidaException("La cantidad ingresada es inválida (negativa).");
        }
        inventario.put(nombre, nuevaCantidad);
    }

}

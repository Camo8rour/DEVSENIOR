import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map inventario = new HashMap<>();

    public void agregarProducto(String nombre, Integer cantidad) {
        inventario.put(nombre, cantidad);
    }

    public String eliminarProducto(String nombre){
        if (!inventario.containsKey(nombre)){
            throw new ProductoNoEncontradoException("El producto" + nombre + " no existe en el inventario.");
        }
        return (String) inventario.get(nombre);
    }

    // public String buscarProducto(String nombre){
    //     if (!inventario.containsKey(nombre)){
    //         throw new ProductoNoEncontradoException("El producto" + nombre + " no existe en el inventario.");
    //     }
    //     return inventario.get(cantidad);
    // }

    public void actualizarCantidad(String nombre, int nuevaCantidad) throws CantidadInvalidaException{
        if (!inventario.containsKey(nombre)){
            throw new ProductoNoEncontradoException("El producto" + nombre + " no existe en el inventario.");
        }else if (!inventario.containsValue(nuevaCantidad)){
            throw new CantidadInvalidaException("La cantidad ingresada es inválida (negativa).");
        }
    }

}

package com.devsenior.camorour;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Inventario {

    private static final Logger LOG = LoggerFactory.getLogger(Inventario.class);

    private List<Producto> productos;

    public Inventario() {
        LOG.debug("Creando la instancia del inventario.");
        productos = new ArrayList<>();
    }

    public void agregarProducto(String nombre, int cantidad) {
        LOG.trace("Ingreso a agregar producto.");
        LOG.debug("Ingresa con los datos: {} {}", nombre, cantidad);

        var producto = new Producto(nombre, cantidad);
        LOG.warn("Agregando el producto {}", nombre);
        productos.add(producto);
        LOG.info("Se creo el producto.");
    }

    public Producto eliminarProducto(String nombre) {
        LOG.trace("Ingreso a eliminar producto.");
        LOG.debug("Ingresa con los datos: {}", nombre);

        for (var producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                LOG.warn("Eliminando el producto {}", producto);
                productos.remove(producto);
                LOG.info("Se elimino el producto.");
                return producto;
            }
        }
        LOG.warn("El producto no existe: {}", nombre);
        throw new ProductoNoEncontradoException("El productono existe.");
    }

    public Producto buscarProducto(String nombre) {
        LOG.trace("Ingreso a buscar un producto.");
        LOG.debug("Ingresa con los datos {}", nombre);
        for (var producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                LOG.info("Producto encontrado: {} con cantidad: {}", producto.getNombre(), producto.getCantidad());
                return producto;
            }
        }

        LOG.warn("El producto no fue encontrado!");
        throw new ProductoNoEncontradoException("El producto no existe en el inventario.");
    }

    public void actualizarCantidad(String nombre, int nuevaCantidad) throws CantidadInvalidaException {
        LOG.trace("Ingreso a agregar producto.");
        LOG.debug("Ingresa con los datos: {} {}", nombre, nuevaCantidad);

        //Producto no extiste.
        try {
            for (var producto : productos) {
                if (producto.getNombre().equals(nombre)) {
                    producto.setCantidad(nuevaCantidad);
                }
            }
        } catch (Exception e) {
            LOG.warn("El producto no fue encontrado!");
            throw new ProductoNoEncontradoException("El producto no existe en el inventario.");
        }

        // Cantidad es negativa.
        if (nuevaCantidad < 0) {
            LOG.warn("La cantidad ingresada es inválida (negativa).");
            throw new CantidadInvalidaException("La cantidad ingresada es inválida (negativa).");
        }
    }
}

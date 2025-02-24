# EJERCICIOS - CLASE 8 🖋️

# Calculadora de Inventario

El objetivo de este proyecto es desarrollar una aplicación de consola en Java que funcione como una calculadora de inventario para una pequeña tienda. La aplicación permitirá al usuario gestionar productos, incluyendo la adición, visualización, búsqueda, actualización y análisis del inventario. Este proyecto está diseñado para practicar conceptos básicos de programación en Java, así como introducir funciones anónimas (lambdas).

## Requisitos funcionales
1. **Menú Interactivo**:
    - Implementar un menú interactivo que permita al usuario seleccionar diferentes opciones.
    - Opciones del menú:
      - Ingresar producto
      - Mostrar productos
      - Buscar producto
      - Actualizar producto
      - Calcular valor total del inventario
      - Mostrar producto más caro y más barato
      - Salir
1. **Ingreso de Productos**:
    - Permitir al usuario ingresar el nombre, cantidad y precio de un producto.
    - Validar que no se exceda un límite máximo de productos (100 productos).
1. **Mostrar Productos**: 
    - Mostrar una lista de todos los productos ingresados, incluyendo nombre, cantidad y precio.
1. **Buscar Producto**: 
    - Implementar una función que permita buscar un producto por su nombre utilizando lambdas.
    - Mostrar los detalles del producto si se encuentra.
1. **Actualizar Producto**:
    - Permitir al usuario actualizar la cantidad y el precio de un producto existente.
1. **Calcular Valor Total del Inventario**:
    - Calcular y mostrar el valor total del inventario (suma de cantidad * precio para todos los productos).
1. **Producto Más Caro y Más Barato**:
    - Identificar y mostrar el producto con el precio más alto y el producto con el precio más bajo.

## Requisitos técnicos
- **Manejo de Variables y Tipos de Datos**: Utilizar String para nombres, int para cantidades, y double para precios.
- **Operadores**: Utilizar operadores aritméticos, relacionales y lógicos donde sea necesario.
- **Estructuras de Control de Flujo**: Uso de `if`, `switch`, `for`, `do-while` y `while`para control de flujo.
- **Arreglos**: Utilizar arreglos para almacenar los detalles de los productos, simulando una base de datos básica.
- **Funciones Anónimas (Lambdas)**: Implementar lambdas para operaciones específicas como búsqueda de productos.
- **Interacción con el Usuario**: Utilizar la clase `Scanner` para capturar la entrada del usuario.
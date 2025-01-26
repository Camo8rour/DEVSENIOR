# Ejercicios de excepciones y manejo de errores.

## Ejercicio 1️⃣ - Sistema de Gestión de Inventario
Permite agregar, eliminar, buscar y actualizar productos en el inventario. 

### Descripción:
1. Excepción personalizada llamada `ProductoNoEncontradoException` que extiende de`RuntimeException`, esta excepción es lanzada cuando se intenta buscar o eliminar un producto que no existe en el inventario.
2. Excepción personalizada llamada `CantidadInvalidaException` que extiende de `Exception`, esta excepción se lanzada cuando se intenta actualizar la cantidad de un producto a un valor negativo.
3. Clase llamada `Inventario` que contiene métodos para agregar, eliminar, buscar y actualizar productos.
    - Método `agregarProducto(String nombre, int cantidad)` que agrega un producto al inventario.
    - Método `eliminarProducto(String nombre)` que lanza `ProductoNoEncontradoException` si el producto no existe.
    - Método `buscarProducto(String nombre)` que lanza `ProductoNoEncontradoException` si el producto no existe y devuelva la cantidad disponible. 
    - Método `actualizarCantidad(String nombre, int nuevaCantidad)` que lanza `ProductoNoEncontradoException` en caso de no encontrar el producto y `CantidadInvalidaException` si la cantidad es negativa.
4. Se utilizan bloques `try-catch` para manejar las excepciones que se lanzan por los métodos del `Inventario`, se proporcionan mensajes de error adecuados para el usuario.
5. Clase principal `App` que permite al usuario interactuar con el inventario y manejar las excepciones adecuadamente.

#### Notas: 
- El método `optionNumber` se encarga de validar que el usuario ingrese una opción numérica válida en el menú principal.
- El método `validInteger` se encarga de validar que la entrada por pantalla sea un número entero positivo, asegura que el valor ingresado sea un número válido y evita que el programa se caiga si en la entrada por pantalla se intenta ingresar caracteres no numéricos.
- El método `pressEnter` sirve para pausar la ejecución del programa y esperar a que se presione la tecla `ENTER` antes de continuar, es útil para dar tiempo al usuario de leer los mensajes o resultados antes de proceder a la siguiente acción.

---

## Ejercicio 2️⃣ - Sistema de Gestión de Reservas de Hotel
Permite registrar clientes, crear reservas y buscar reservas.

### Descripción:
1. Excepción personalizada _unchecked_ llamada `ClienteNoEncontradoException`, esta excepción se lanza cuando se intenta buscar un cliente que no exista en el sistema.
2. Clase  (Checked): Excepción personalizada _checked_ llamada `ReservaInvalidaException`, esta excepción se lanzada cuando se intenta crear una reserva con información inválida (por ejemplo, fechas incorrectas o cliente inexistente).
3. Clase llamada `GestionClientes` que contiene métodos para registrar y buscar clientes.
    - Método `registrarCliente(String id, String nombre)` que registra un cliente en el sistema.
    - Método `buscarCliente(String id)` que lanza `ClienteNoEncontradoException` si el cliente no existe.
4. Clase llamada `GestionReservas` que contiene métodos para crear y buscar reservas.
    - Método `crearReserva(String clienteId, String fechaInicio, String fechaFin)` que lanza `ReservaInvalidaException` si la información de la reserva es inválida.
    - Método `buscarReserva(String clienteId, String fechaInicio)` que lanza `ClienteNoEncontradoException` si el cliente no existe.
5. Se utilizan bloques `try-catch` para manejar las excepciones que se lanzan por los métodos del `GestionClientes` y `GestionReservas`, proporcionando mensajes de error adecuados para el usuario.
6. Clase principal que permite al usuario interactuar con el sistema de gestión de clientes y reservas, y maneja las excepciones adecuadamente.

#### Notas: 
- El método `optionNumber` se encarga de validar que el usuario ingrese una opción numérica válida en el menú principal.
- El método `esFechaValida` verifica si la fecha proporcionada es válida, donde el formato esperado es YYYY-MM-DD, la cual se usa para validar las fechas de inicio y fin de las reservas.
- El método `pressEnter` sirve para pausar la ejecución del programa y esperar a que se presione la tecla `ENTER` antes de continuar, es útil para dar tiempo al usuario de leer los mensajes o resultados antes de proceder a la siguiente acción.
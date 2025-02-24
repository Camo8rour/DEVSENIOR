# EJERCICIOS - CLASE 18 y 19 📚

# Ejercicios mejorados de excepciones y manejo de errores.

## [Sistema de Gestión de Clientes y Pedidos](clientes-pedidos)
Permite registrar clientes, crear pedidos y buscar pedidos. Maneja adecuadamente las excepciones relacionadas con la gestión de clientes y pedidos utilizando excepciones personalizadas tanto verificadas (checked) como no verificadas (unchecked).

### Descripción:
1. Excepción personalizada llamada `ClienteNoEncontradoException` que extiende `RuntimeException`, se lanza cuando se intente buscar un cliente que no exista en el sistema.
2. excepción personalizada llamada `PedidoInvalidoException` que extiende `Exception`, se lanza cuando se intente crear un pedido con información inválida (por ejemplo, cantidad negativa o cliente inexistente).
3. Clase llamada `GestionClientes` que contenga métodos para registrar y buscar clientes.
    - Método `registrarCliente(String id, String nombre)` que registra un cliente en el sistema.
    - Método `buscarCliente(String id)` que lanza `ClienteNoEncontradoException` si el cliente no existe.
4. Clase llamada `GestionPedidos` que contiene métodos para crear y buscar pedidos.
    - Método `crearPedido(String clienteId, String producto, int cantidad)` que lanza `PedidoInvalidoException` si la información del pedido es inválida.
    - Método `buscarPedido(String clienteId, String producto)` que lanza `ClienteNoEncontradoException` si el cliente no existe.
5. Bloques `try-catch` para manejar las excepciones que se lanzan por los métodos del `GestionClientes` y `GestionPedidos`, proporciona mensajes de error adecuados para el usuario.
6. Clase principal que permite al usuario interactuar con el sistema de gestión de clientes y pedidos, y maneja las excepciones adecuadamente.

---

## [Sistema de Gestión de Inventario](gestion-inventario)
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

---

## [Sistema de Gestión de Reservas de Hotel](reservas-hotel)
Permite registrar clientes, crear reservas y buscar reservas.

### Descripción:
1. Excepción personalizada _unchecked_ llamada `ClienteNoEncontradoException`, esta excepción se lanza cuando se intenta buscar un cliente que no exista en el sistema.
2. Excepción personalizada _checked_ llamada `ReservaInvalidaException`, esta excepción se lanzada cuando se intenta crear una reserva con información inválida (por ejemplo, fechas incorrectas o cliente inexistente).
3. Clase llamada `GestionClientes` que contiene métodos para registrar y buscar clientes.
    - Método `registrarCliente(String id, String nombre)` que registra un cliente en el sistema.
    - Método `buscarCliente(String id)` que lanza `ClienteNoEncontradoException` si el cliente no existe.
4. Clase llamada `GestionReservas` que contiene métodos para crear y buscar reservas.
    - Método `crearReserva(String clienteId, String fechaInicio, String fechaFin)` que lanza `ReservaInvalidaException` si la información de la reserva es inválida.
    - Método `buscarReserva(String clienteId, String fechaInicio)` que lanza `ClienteNoEncontradoException` si el cliente no existe.
5. Se utilizan bloques `try-catch` para manejar las excepciones que se lanzan por los métodos del `GestionClientes` y `GestionReservas`, proporcionando mensajes de error adecuados para el usuario.
6. Clase principal que permite al usuario interactuar con el sistema de gestión de clientes y reservas, y maneja las excepciones adecuadamente.

---

#### Notas:
- Se utilizalan las herramientas de Logging `Log4j 2` y `SLF4J`.
- Se usa la herramienta de automatización y gestión de proyectos `Maven`.
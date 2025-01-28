# Sistema de Gestión de Clientes y Pedidos
Permite registrar clientes, crear pedidos y buscar pedidos. Maneja adecuadamente las excepciones relacionadas con la gestión de clientes y pedidos utilizando excepciones personalizadas tanto verificadas (checked) como no verificadas (unchecked).
## Requisitos:
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
### Notas:
-Se utilizalan las herramientas de Logging `Log4j 2` y `SLF4J`.
-Se usa la herramienta de automatización y gestión de proyectos `Maven`.
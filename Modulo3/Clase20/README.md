# EJERCICIOS - CLASE 20 📑

# Corrigiendo errores.

## [Sistema de Gestión de Inventario](demo-bug)
Permite agregar productos, vender productos y calcular el total del inventario.

### Descripción:
1. Se presenta un programa donde se resuelven errores e inconvenientes donde para ello se utilizan las siguientes excepciones.
- Excepción personalizada _unchecked_ llamada `NotEnoughQuantityException`, esta excepción se lanza cuando se intenta vender un producto y la cantidad es insuficiente.
- Excepción personalizada _checked_ llamada `NotFoundException`, esta excepción se lanzada cuando un producto no se encuentra en el inventario.

2. Se utilizan bloques `try-catch` para manejar las excepciones que se lanzan por los métodos de `Inventory` proporcionando mensajes de error adecuados para el usuario.

---

#### Notas:
- Se utilizalan las herramientas de Logging `Log4j 2` y `SLF4J`.
- Se usa la herramienta de automatización y gestión de proyectos `Maven`.
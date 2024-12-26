# 🍽️ **Gestión de Restaurante (Composición)**

1. **Clases de componentes**:
   - **Cocina** 🍳: Método `prepararPlato()`, que imprime "Plato preparado".
   - **Mesero** 🍽️: Método `servir()`, que imprime "El mesero está sirviendo el plato.".
   - **Caja** 💳: Método `procesarPago()`, que imprime "Pago procesado".
   
2. **Clase Restaurante** 🏨:
   - Atributos:
     - **Cocina cocina**: Instancia de la clase `Cocina`.
     - **Mesero mesero**: Instancia de la clase `Mesero`.
     - **Caja caja**: Instancia de la clase `Caja`.
   - Método `operarRestaurante()`: Este método llamará a los métodos de las clases `Cocina`, `Mesero` y `Caja`.

# 🌐 Sistema de Gestión de Pagos 💳💰

## 🛠️ Definición del Sistema
Está asado en la **interfaz** `MetodoPago`, que es implementada por diferentes clases que representan métodos de pago distintos. Cada clase valida, procesa y obtiene detalles específicos de su tipo de pago.

### 📌 Interfaz `MetodoPago`
La interfaz define tres métodos abstractos comunes para todos los métodos de pago:

- `void procesarPago(double monto)`: Procesa el pago e imprime cómo se realiza.
- `String obtenerDetalles()`: Devuelve detalles específicos del método de pago.
- `boolean validarMonto(double monto)`: Valida si el monto es aceptable según las reglas del método de pago.

### 📚 Clases que implementan la interfaz
Cada clase representa un método de pago y **implementa los tres métodos de la interfaz** según sus reglas específicas:

1. **TarjetaCredito** 💳
   - Procesa pagos con tarjeta de crédito.
   - Valida que el monto sea mayor que 0.
   
2. **PayPal** 💸
   - Procesa pagos mediante la plataforma PayPal.
   - Valida que el monto esté entre 1 y 10,000.

3. **TransferenciaBancaria** 🏦
   - Procesa pagos mediante transferencia bancaria.
   - Valida que el monto sea mayor o igual a 10.

4. **Bitcoin** ₿
   - Procesa pagos en criptomonedas (Bitcoin).
   - Valida que el monto sea mayor o igual a 0.001 BTC.

5. **TarjetaRegalo** 🎁
   - Procesa pagos con tarjetas de regalo.
   - Valida que el monto sea mayor que 0 y menor o igual a 500.

### 🧑‍💻 Clase Principal (`Main`)
La clase principal simula el uso del sistema:

- **Crea una lista** de diferentes métodos de pago.
- **Valida los montos** antes de procesar los pagos.
- **Imprime los detalles** de cada método de pago.
- **Procesa los pagos** solo si los montos son válidos.

---

## ⚙️ Cómo funciona

### 1. **Validación de Montos** 📏
Cada clase valida el monto según las reglas definidas:
- **TarjetaCredito**: El monto debe ser **mayor que 0**.
- **PayPal**: El monto debe estar entre **1 y 10,000**.
- **TransferenciaBancaria**: El monto debe ser **mayor o igual a 10**.
- **Bitcoin**: El monto debe ser **mayor o igual a 0.001 BTC**.
- **TarjetaRegalo**: El monto debe ser **mayor que 0** y **menor o igual a 500**.

### 2. **Procesamiento de Pagos** 💳💸
Solo los montos válidos son procesados. Si el monto es válido según las reglas de cada clase, el sistema imprime un mensaje indicando cómo se realiza el pago.

### 3. **Detalles del Método de Pago** 📝
Cada método de pago tiene su propia forma de procesar pagos, y el sistema imprime los detalles de cómo funciona cada uno:

- **TarjetaCredito**: "Se realizó el pago con la targeta de crédito"
- **PayPal**: "Se realizó el pago con PayPal"
- **TransferenciaBancaria**: "Se realizó el pago por transferencia bancaria"
- **Bitcoin**: "Se realizó el pago con Bitcoin"
- **TarjetaRegalo**: "Se realizó el pago con tarjeta de regalo."

---
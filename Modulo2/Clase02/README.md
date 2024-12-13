# 🚗 Gestión de Vehículos 🏍️

Este sistema permite gestionar diferentes tipos de vehículos utilizando los conceptos de programación orientada a objetos. 🚀

## 📋 Descripción

En este ejercicio, implementamos una estructura de clases en Java para gestionar diferentes tipos de vehículos, aplicando principios fundamentales como la herencia, encapsulación y métodos sobrescritos. Cada tipo de vehículo tiene características únicas y detalles que podemos mostrar fácilmente.

---

## 🛠️ Estructura del Código

### 📂 Clases

1. **Clase Base: `Vehiculo`** 🚘
   - **Atributos:**
     - `marca`: Marca del vehículo.
     - `modelo`: Modelo del vehículo.
     - `velocidadMaxima`: Velocidad máxima del vehículo.
   - **Métodos:**
     - Constructor para inicializar los atributos.
     - `mostrarDetalles()`: Imprime detalles del vehículo.

2. **Clases Derivadas:**
   - **`Carro`** 🚗
     - Atributo adicional: `numPuertas` (Número de puertas del carro).
   - **`Moto`** 🏍️
     - Atributo adicional: `tieneSidecar` (Indica si la moto tiene sidecar).

### 🖥️ Clase Principal: `Main`

- Creamos objetos de tipo `Carro` y `Moto`.
- Mostramos los detalles con el método `mostrarDetalles()`.
- Representación en texto del objeto `toString()`.

---

## 🌟 Funcionalidades

- **Encapsulación:** Uso de getters y setters para los atributos.
- **Herencia:** Clases derivadas (`Carro` y `Moto`) que extienden de la clase base `Vehiculo`.
- **Sobrescritura:** Métodos como `toString()` y `equals()` implementados en las clases para personalizar su comportamiento.
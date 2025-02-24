# EJERCICIOS - CLASE 1 💻

## 📂 Clase `Student`
La clase `Student` es el núcleo del programa y define las características y comportamiento de los estudiantes.

### ✏️ **Atributos**:
- **`name`**: Nombre del estudiante (String).
- **`age`**: Edad del estudiante (int).
- **`average`**: Promedio de calificaciones (float).

### 🔧 **Métodos**:
1. **Constructor con parámetros**:
   - Recibe nombre, edad y promedio para crear un estudiante personalizado.
2. **`mostrarDetalles()`**:
   - Muestra la información del estudiante.
   ```java
   public void mostrarDetalles() {
        System.out.printf("Nombre: %s.%n", name);
        System.out.printf("Edad: %d.%n", age);
        System.out.printf("Promedio: %f.%n", average);
   }
   ```
3. **`esAprobado()`**:
   - Devuelve `true` si el promedio es mayor o igual a 3.0.
   ```java
   public boolean esAprobado() {
       return average >= 3.0;
   }
   ```

---

## 🚀 Clase `Main`
Esta clase contiene el punto de entrada del programa y utiliza la clase `Student` para gestionar una lista de estudiantes.

### 📋 **Pasos principales**:
1. **Crear una lista de estudiantes**:
   ```java
   List<Student> students = new ArrayList<>();
   ```
2. **Agregar estudiantes**:
   - Se crean objetos `Student` y se añaden a la lista.
   ```java
   students.add(new Student("Juan Pérez", 15, 4.2f));
   students.add(new Student("María López", 14, 2.8f));
   students.add(new Student("Carlos Gómez", 16, 3.5f));
   ```
3. **Mostrar los estudiantes**:
   ```java
   for (Student student : students) {
       student.mostrarDetalles();
       System.out.println("¿Está aprobado?: " + (student.esAprobado() ? "Sí" : "No"));
       System.out.println();
   }
   ```
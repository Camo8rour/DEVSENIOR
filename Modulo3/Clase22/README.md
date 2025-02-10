# Pruebas unitarias con Mockito
Se hacen pruebas unitarias con la implementación del framework, donde se crean objetos simulados en `LoanUser` con `BookService` y `UserService`.

# Proyecto de Gestión de Préstamos de Libros

Este proyecto es un **sistema de gestión de préstamos de libros** desarrollado en **Java**, que permite administrar usuarios, libros y préstamos de manera eficiente. Utiliza una arquitectura basada en servicios para manejar las operaciones principales.

## Características Principales
- **Gestión de Usuarios**
  - Agregar usuarios con Id, nombre, correo y fecha de registro.
  - Consultar usuarios por Id.
  - Actualizar datos de usuario (nombre y correo electrónico).
  - Eliminar usuarios del sistema.

- **Gestión de Libros**
  - Agregar libros con ISBN, título y autor.
  - Consultar libros por ISBN.
  - Actualizar información de un libro.
  - Eliminar libros del sistema.

- **Gestión de Préstamos**
  - Registrar préstamos de libros a usuarios.
  - Devolver libros prestados.
  - Consultar todos los préstamos activos.
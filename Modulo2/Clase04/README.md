# EJERCICIOS - CLASE 4 🧑‍🏫

# 🛠️ **Gestión de Notificaciones (Factory)**

1. **Implementaciones concretas**:
   - **CorreoNotificacion** 📧: Imprime el mensaje "Enviando correo: [mensaje]".
   - **SMSNotificacion** 📱: Imprime el mensaje "Enviando SMS: [mensaje]".
   - **PushNotificacion** 🔔: Imprime el mensaje "Enviando notificación push: [mensaje]".
   
   El **[mensaje]** es un parámetro que se pasa al crear la notificación.

2. **Clase Factory**:
   - **NotificacionFactory** 🏭: Implementa una fábrica que devuelve el canal adecuado (correo, SMS o push) según un parámetro proporcionado.

3. **Tipos**:

    - **TipoNotificacion** 🔢: Es un enum que define los tres tipos de notificación disponibles: CORREO, SMS, y PUSH.
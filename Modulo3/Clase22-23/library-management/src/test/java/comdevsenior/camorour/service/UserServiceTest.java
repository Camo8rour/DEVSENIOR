package comdevsenior.camorour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import comdevsenior.camorour.exception.NotFoundException;
import comdevsenior.camorour.model.User;

public class UserServiceTest {

    private UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService();
    }

    @DisplayName("Agregar un usuario")
    @Test
    void testAddUserWithoutDate() throws NotFoundException {
        // GIVEN
        String id = "1234";
        String name = "Camilo";
        String email = "camo321@gmail.com";

        // WHEN
        service.addUser(id, name, email);

        // THEN
        var user = service.getUserById(id);
        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
    }

    @DisplayName("Agregar un usuario con fecha de registro")
    @Test
    void testAddUserWithDate() throws NotFoundException {
        // GIVEN
        String id = "5678";
        String name = "Andrea";
        String email = "andrea@gmail.com";
        LocalDate registerDate = LocalDate.of(2025, 2, 11);

        // WHEN
        service.addUser(id, name, email, registerDate);

        // THEN
        var user = service.getUserById(id);
        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(registerDate, user.getRegisterDate());
    }

    @Test
    void testGetAllBooks() {
        // GIVEN

        // WHEN
        var users = service.getAllUsers();

        // THEN
        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @DisplayName("Obtener un usuario por ID existente")
    @Test
    void testGetUserById() throws NotFoundException {
        // GIVEN
        service.addUser("1234", "Camilo", "camo321@gmail.com");

        // WHEN
        var id = "12121";

        // THEN
        assertThrows(NotFoundException.class, 
                () -> service.getUserById(id));
    }

    @DisplayName("Obtener un usuario por ID inexistente")
    @Test
    void testGetUserByIdNotFound() {
        // GIVEN
        var id = "1234";

        // WHEN - THEN
        assertThrows(NotFoundException.class, 
        () -> {
            service.getUserById(id);
        });
    }

    @DisplayName("Actualizar el email de un usuario existente")
    @Test
    void testUpdateUserEmail() throws NotFoundException {
        // GIVEN
        service.addUser("1234", "Camilo", "camo321@gmail.com");

        // WHEN
        service.updateUserEmail("1234", "pepitoperez@gmail.com");

        // THEN
        User user = service.getUserById("1234");
        assertEquals("pepitoperez@gmail.com", user.getEmail());
    }

    @DisplayName("Actualizar el nombre de un usuario existente")
    @Test
    void testUpdateUserName() throws NotFoundException {
        // GIVEN
        service.addUser("1234", "Camilo", "camo321@gmail.com");

        // WHEN
        service.updateUserName("1234", "Carlos");

        // THEN
        User user = service.getUserById("1234");
        assertEquals("Carlos", user.getName());
    }

    @DisplayName("Eliminar un usuario existente")
    @Test
    void testDeleteExistingUser() throws NotFoundException {
        // GIVEN
        var id = "1234";
        var name = "Camilo";
        var email = "camo321@gmail.com";
        service.addUser(id, name, email);

        // WHEN
        service.deleteUser(id);

        // THEN
        try {
            service.getUserById(id);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @DisplayName("Intentar eliminar un usuario inexistente")
    @Test
    void testDeleteNonExistingUser() {
        // GIVEN
        var id = "1234";

        // WHEN - THEN
        assertThrows(NotFoundException.class, 
        () -> {
            service.deleteUser(id);
        });
    }

}

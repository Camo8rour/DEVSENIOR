package comdevsenior.camorour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comdevsenior.camorour.exception.NotFoundException;

public class BookServiceTest {

    private BookService service;

    @BeforeEach
    void setUp() {
        service = new BookService();
    }

    @Test
    void testAddBook() throws NotFoundException {
        // GIVEN - Preparar los datos de la prueba
        var isbn = "1234";
        var title = "The Lord of the Rings";
        var author = "JRR Tolkien";

        // WHEN - Ejecutar el metodo a probar
        service.addBook(isbn, title, author);

        // THEN - Verificaciones que el metodo se ejecutó bien.
        var book = service.getBookByIsbn(isbn);
        assertNotNull(book);
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
    }

    @Test
    void testDeleteExistingBook() throws NotFoundException {
        // GIVEN
        var isbn = "1234";
        var title = "The Lord of the Rings";
        var author = "JRR Tolkien";
        service.addBook(isbn, title, author);

        // WHEN
        service.deleteBook(isbn);

        // THEN
        try {
            service.getBookByIsbn(isbn);
            fail();
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void testDeleteNonExistingBook(){
        // GIVEN
        var isbn = "1234";

        // WHEN - THEN
        assertThrows(NotFoundException.class, 
        () -> {
            service.deleteBook(isbn);
        });
    }

    @Test
    void testDeleteWithExistingBooksButNotGivenIsbn() {
        // GIVEN
        service.addBook("38947743", "La sombra del viento", "Duvan Urrego");
        var isbn = "3453425342";

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> service.deleteBook(isbn));
    }

    @Test
    void testGetAllBooks() {
        // GIVEN

        // WHEN
        var books =service.getAllBooks();

        // THEN
        assertNotNull(books);
        assertEquals(0, books.size());
    }

    @Test
    void testGetBookByIsbnWithWrongIsbn() throws NotFoundException {
        // GIVEN
        service.addBook("1234", "The Lord of the Rings", "JRR Tolkien");

        // WHEN
        var isbn = "012030";

        // THEN
        assertThrows(NotFoundException.class, 
                () -> service.getBookByIsbn(isbn));
    }

}

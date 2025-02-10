package comdevsenior.camorour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import comdevsenior.camorour.exception.NotFoundException;
import comdevsenior.camorour.model.Book;

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
    void testGetAllBooks() {
        // GIVEN
        service.addBook("1234", "The Lord of the Rings", "JRR Tolkien");
        service.addBook("5678", "Los dolores de cabeza con java", "Camilo Rodriguez");
        service.addBook("91011", "La vualta al mundo en 80 días", "Julio Verne");

        // WHEN
        List<Book> books = service.getAllBooks();
        assertEquals(3, books.size());

        // THEN
        assertEquals("1234", books.get(0).getIsbn());
        assertEquals("5678", books.get(1).getIsbn());
        assertEquals("91011", books.get(2).getIsbn());
    }

    @Test
    void testGetBookByIsbn() throws NotFoundException {
        // GIVEN
        var isbn = "1234";
        var title = "The Lord of the Rings";
        var author = "JRR Tolkien";
        service.addBook(isbn, title, author);

        // WHEN
        Book foundBook = service.getBookByIsbn(isbn);

        // THEN
        assertEquals(isbn, foundBook.getIsbn());
    }

    @Test
    void testGetBookByIsbnNotFound() throws NotFoundException {
         // GIVEN
         var isbn = "1234";

         // WHEN - THEN
         assertThrows(NotFoundException.class, 
         () -> {
             service.getBookByIsbn(isbn);
         });
    }
}

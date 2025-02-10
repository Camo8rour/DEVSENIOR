package comdevsenior.camorour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import comdevsenior.camorour.exception.NotFoundException;
import comdevsenior.camorour.model.Book;
import comdevsenior.camorour.model.LoanState;
import comdevsenior.camorour.model.User;

public class LoanServiceTest {

    private BookService bookService;
    private UserService userService;
    private LoanService service;

    @BeforeEach
    void setUp() {
        bookService = Mockito.mock(BookService.class);
        userService = Mockito.mock(UserService.class);
        service = new LoanService(bookService, userService);
    }

    @DisplayName("Agregar un prestamo con un usuario y un libro existente")
    @Test
    void testAddLoanWithExistingUserAndBook() throws NotFoundException {
        // GIVEN
        var id = "1234";
        var isbn = "1111";
        var mockUser = new User(id, "Camilo", "camo321@gmail.com");
        var mockBook = new Book(isbn, "The Lord of the Rings", "JRR Tolkien");

        Mockito.when(userService.getUserById(id)).thenReturn(mockUser);
        Mockito.when(bookService.getBookByIsbn(isbn)).thenReturn(mockBook);

        // WHEN
        service.addLoan(id, isbn);

        // THEN
        var loans = service.getLoans();
        assertEquals(1, loans.size());
        
        var loan = loans.get(0);
        assertNotNull(loan.getUser());
        assertNotNull(loan.getBook());
        assertEquals(LoanState.STARTED, loan.getState());
    }

    @DisplayName("Intentar agregar un préstamo con un usuario inexistente")
    @Test
    void testAddLoanWithNonExistingUser() throws NotFoundException {
        // GIVEN
        var id = "0192";
        var isbn = "1321";
        var mockBook = new Book(isbn, "El dolor de cabeza con java", "Camo Rour");

        Mockito.when(userService.getUserById(id)).thenThrow(new NotFoundException("Usuario no encontrado"));
        Mockito.when(bookService.getBookByIsbn(isbn)).thenReturn(mockBook);

        // WHEN - THEN
        assertThrows(NotFoundException.class, () -> service.addLoan(id, isbn));
    }

    @DisplayName("Intentar agregar un préstamo con un libro inexistente")
    @Test
    void testAddLoanWithNonExistingBook() throws NotFoundException {
        // GIVEN
        var id = "1234";
        var isbn = "9999";
        var mockUser = new User(id, "Camilo", "camo321@gmail.com");

        Mockito.when(userService.getUserById(id)).thenReturn(mockUser);
        Mockito.when(bookService.getBookByIsbn(isbn)).thenThrow(new NotFoundException("Libro no encontrado."));

        // WHEN - THEN
        assertThrows(NotFoundException.class, () -> service.addLoan(id, isbn));
    }

    @DisplayName("Devolver un libro correctamente")
    @Test
    void testReturnBook() throws NotFoundException {
        // GIVEN
        var id = "1234";
        var isbn = "1111";
        var mockUser = new User(id, "Camilo", "camo321@gmail.com");
        var mockBook = new Book(isbn, "Harry Potter", "J.K. Rowling");

        Mockito.when(userService.getUserById(id)).thenReturn(mockUser);
        Mockito.when(bookService.getBookByIsbn(isbn)).thenReturn(mockBook);

        service.addLoan(id, isbn);

        // WHEN
        service.returnBook(id, isbn);

        // THEN
        var loans = service.getLoans();
        assertEquals(1, loans.size());
        assertEquals(LoanState.FINISHED, loans.get(0).getState());
    }

    @DisplayName("Intentar devolver un libro que no ha sido prestado")
    @Test
    void testReturnNonExistingLoan() {
        // GIVEN
        var id = "9999";
        var isbn = "8888";

        // WHEN - THEN
        assertThrows(NotFoundException.class, () -> service.returnBook(id, isbn));
    }
}

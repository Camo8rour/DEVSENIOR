package comdevsenior.camorour.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import comdevsenior.camorour.exception.NotFoundException;
import comdevsenior.camorour.model.Book;
import comdevsenior.camorour.model.Loan;
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
        var mockUser = new User(id, "Duvan", "camo321@gmail.com");
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

    @DisplayName("Retornar con un usuario y un libro existente")
    @Test
    void testReturnBookWithExistingLoan() throws NotFoundException {
        // GIVEN
        var id = "1234";
        var isbn = "1111";

        var userMock = new User(id, "Camilo", "camo321@gmail.com");
        var bookMock = new Book(isbn, "The Lord of the Rings", "JRR Tolkien");

        Mockito.when(userService.getUserById(anyString())).thenReturn(userMock);
        Mockito.when(bookService.getBookByIsbn(anyString())).thenReturn(bookMock);

        service.addLoan(id, isbn);

        // WHEN
        service.returnBook(id, isbn);

        // THEN
        var loans = service.getLoans();
        assertEquals(1, loans.size());

        var loan = loans.get(0);
        assertEquals(id, loan.getUser().getId());
        assertEquals(isbn, loan.getBook().getIsbn());
        assertEquals(LoanState.FINISHED, loan.getState());
    }

    @DisplayName("Préstamo con un libro ya prestado")
    @Test
    void testAddLoanWithAlreadyLoanedBook() throws NotFoundException {
        // GIVEN
        var id = "1234";
        var isbn = "1111";

        var mockUser = new User(id, "Duvan", "camo321@gmail.com");
        var mockBook = new Book(isbn, "The Lord of the Rings", "JRR Tolkien");

        Mockito.when(userService.getUserById(anyString())).thenReturn(mockUser);
        Mockito.when(bookService.getBookByIsbn(anyString())).thenReturn(mockBook);

        service.addLoan(id, isbn);

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> {
                    service.addLoan(id, isbn);
                });
    }

    @DisplayName("Préstamo con usuario no existente")
    @Test
    void testAddLoanWithNonExistingUser() throws NotFoundException {
        // GIVEN
        var id = "9999";
        var isbn = "1111";

        Mockito.when(userService.getUserById(anyString())).thenThrow(new NotFoundException("Usuario no encontrado"));

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> {
                    service.addLoan(id, isbn);
                });
    }

    @DisplayName("Préstamo con libro no existente")
    @Test
    void testAddLoanWithNonExistingBook() throws NotFoundException {
        // GIVEN
        var id = "1234";
        var isbn = "9999";

        var mockUser = new User(id, "Duvan", "camo321@gmail.com");

        Mockito.when(userService.getUserById(anyString())).thenReturn(mockUser);
        Mockito.when(bookService.getBookByIsbn(anyString())).thenThrow(new NotFoundException("Libro no encontrado"));

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> {
                    service.addLoan(id, isbn);
                });
    }

    // 1
    @DisplayName("No se puede prestar un libro que ya está prestado")
    @Test
    void testAddLoanBookAlreadyLoanedFullCondition() throws NotFoundException {
        // GIVEN
        var userId = "1234";
        var isbn = "1111";
        var loanDate = LocalDate.of(2023, 10, 1);

        var user = new User(userId, "Duvan", "camo321@gmail.com");
        var book = new Book(isbn, "The Lord of the Rings", "JRR Tolkien");

        when(userService.getUserById(userId)).thenReturn(user);
        when(bookService.getBookByIsbn(isbn)).thenReturn(book);

        var existingLoan = new Loan(user, book, loanDate);
        existingLoan.setState(LoanState.STARTED);
        service.getLoans().add(existingLoan);

        // WHEN y THEN
        var exception = assertThrows(NotFoundException.class, () -> {
            service.addLoan(userId, isbn);
        });

        assertEquals("El libro con el isbn: " + isbn + " se encuentra prestado", exception.getMessage());
    }

    @DisplayName("Retornar un libro inexistente")
    @Test
    void testReturnBookWithNonExistingLoan() {
        // GIVEN
        var id = "1234";
        var isbn = "1111";

        // WHEN - THEN
        assertThrows(NotFoundException.class,
                () -> {
                    service.returnBook(id, isbn);
                });
    }

    //2
    @DisplayName("Devolver un libro prestado correctamente")
    @Test
    void testReturnBook() throws NotFoundException {
        // GIVEN
        var userId = "1234";
        var isbn = "1111";
        var loanDate = LocalDate.of(2023, 10, 1);

        var user = new User(userId, "Duvan", "camo321@gmail.com");
        var book = new Book(isbn, "The Lord of the Rings", "JRR Tolkien");

        // Añadimos un préstamo con el usuario, libro e ID que queremos probar
        var loan = new Loan(user, book, loanDate);
        loan.setState(LoanState.STARTED);
        service.getLoans().add(loan);

        // WHEN
        service.returnBook(userId, isbn);

        // THEN
        assertEquals(LoanState.FINISHED, loan.getState());
    }

}
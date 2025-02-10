package comdevsenior.camorour.service;

import java.util.ArrayList;
import java.util.List;

import comdevsenior.camorour.exception.NotFoundException;
import comdevsenior.camorour.model.Loan;
import comdevsenior.camorour.model.LoanState;

public class LoanService {
    private List<Loan> loans;
    private BookService bookService;
    private UserService userService;

    public LoanService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
        this.loans = new ArrayList<>();
    }

    public void addLoan(String id, String isbn) throws NotFoundException {
        var user = userService.getUserById(id);
        var book = bookService.getBookByIsbn(isbn);
        loans.add(new Loan(user, book));
    }

    public void returnBook(String id, String isbn) throws NotFoundException {
        for (var loan : loans) {
            if (loan.getUser().getId().equals(id) && loan.getBook().getIsbn().equals(isbn) && loan.getState() == LoanState.STARTED) {
                loan.setState(LoanState.FINISHED);
                return;
            }
        }

        throw new NotFoundException("No existe un prestamo con el id: " + id + " y el isbn: " + isbn);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}

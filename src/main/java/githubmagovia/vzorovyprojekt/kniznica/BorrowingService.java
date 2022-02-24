package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowingService {
    private int idCounter = 0;
    private final List<Borrowing> borrowings;
    private final CustomersService customersService;
    private final BooksService booksService;

    public BorrowingService(CustomersService customersService, BooksService booksService) {
        this.borrowings = init();
        this.customersService = customersService;
        this.booksService = booksService;
    }

    private List<Borrowing> init() { return new ArrayList<>(); }

    //get list of borrowings
    public List<Borrowing> getBorrowings() { return this.borrowings; }

    //post borrowing
    public Integer createBorrowing(Borrowing request) {
        Borrowing borrowing = new Borrowing();
        Customers customer = customersService.getCustomerById(request.getCustomerId());
        Book book = booksService.getBook(request.getBookId());
        borrowing.setId(idCounter++);
        borrowing.setCustomerId(request.getCustomerId());
        borrowing.setBookId(request.getBookId());
        borrowing.setCustomerName(customer.getFirstName() + " " + customer.getLastName());
        borrowing.setTitle(book.getName());
        borrowing.setAuthorName(book.getAuthorFirstName() + " " + book.getAuthorLastName());
        this.borrowings.add(borrowing);
        return borrowing.getId();
    }

    //get borrowing by id
    public Borrowing getBorrowing(Integer borrowingId) { return findBorrowing(borrowingId); }

    //delete borrowing
    public void deleteBorrowing(Integer borrowingId){ borrowings.remove(findBorrowing(borrowingId)); }

    private Borrowing findBorrowing(int id) {
        for (Borrowing b : borrowings) {
            if (b.getId() == id) { return b; }
        }
        return null;
    }
}

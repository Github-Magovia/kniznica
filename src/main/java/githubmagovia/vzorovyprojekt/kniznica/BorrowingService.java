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

    //get list of borrowings
    public List<BorrowingBody> getBorrowingBodies() {
        List<BorrowingBody> bodyList = new ArrayList<>(borrowings.size());
        for (Borrowing b : borrowings) { bodyList.add(transformToBody(b)); }
        return bodyList;
    }

    //post borrowing
    public Integer createBorrowing(Borrowing request) {
        Borrowing borrowing = new Borrowing();
        borrowing.setId(idCounter++);
        borrowing.setCustomerId(request.getCustomerId());
        borrowing.setBookId(request.getBookId());
        this.borrowings.add(borrowing);
        return borrowing.getId();
    }

    //get borrowing by id
    public BorrowingBody getBorrowing(Integer borrowingId) { return transformToBody(findBorrowing(borrowingId)); }

    //delete borrowing
    public void deleteBorrowing(Integer borrowingId){ borrowings.remove(findBorrowing(borrowingId)); }

    private Borrowing findBorrowing(int id) {
        for (Borrowing b : borrowings) {
            if (b.getId() == id) { return b; }
        }
        return null;
    }

    // transforms Borrowing into BorrowingBody and sets its values
    private BorrowingBody transformToBody(Borrowing borrowing) {
        BorrowingBody body = new BorrowingBody(borrowing);
        Customers customer = customersService.getCustomerById(body.getCustomerId());
        Book book = booksService.getBook(body.getBookId());
        body.setCustomerName(customer.getFirstName() + " " + customer.getLastName());
        body.setTitle(book.getName());
        body.setAuthorName(book.getAuthorFirstName() + " " + book.getAuthorLastName());
        return body;
    }
}

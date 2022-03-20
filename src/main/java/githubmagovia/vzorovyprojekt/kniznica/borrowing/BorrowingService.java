package githubmagovia.vzorovyprojekt.kniznica.borrowing;

import githubmagovia.vzorovyprojekt.kniznica.book.BookEntity;
import githubmagovia.vzorovyprojekt.kniznica.book.BooksService;
import githubmagovia.vzorovyprojekt.kniznica.customer.CustomersEntity;
import githubmagovia.vzorovyprojekt.kniznica.customer.CustomersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;
    private final CustomersService customersService;
    private final BooksService booksService;

    public BorrowingService(BorrowingRepository borrowings, CustomersService customers, BooksService books) {
        this.borrowingRepository = borrowings;
        this.customersService = customers;
        this.booksService = books;
    }

    //get list of borrowings
    public List<BorrowingEntity> getBorrowings() { return borrowingRepository.findAll(); }

    //post borrowing
    public BorrowingEntity createBorrowing(BorrowingDto request) {
        BorrowingEntity borrowing = new BorrowingEntity();
        CustomersEntity customer = customersService.getCustomerById(request.getCustomerId());
        BookEntity book = booksService.getBookById(request.getBookId());
        if (customer != null && book != null) {
            borrowing.setCustomer(customer);
            borrowing.setBook(book);
            return borrowingRepository.save(borrowing);
        }
        return null;
    }

    //get borrowing by id
    public BorrowingEntity getBorrowingById(Long borrowingId) {
        Optional<BorrowingEntity> borrowing = borrowingRepository.findById(borrowingId);
        return borrowing.orElse(null);
    }

    //delete borrowing
    public void deleteBorrowing(Long borrowingId){ borrowingRepository.deleteById(borrowingId); }
}

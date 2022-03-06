package githubmagovia.vzorovyprojekt.kniznica.borrowing;

import githubmagovia.vzorovyprojekt.kniznica.BooksService;
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
    public BorrowingEntity createBorrowing(Long bookId, Long customerId) {
        BorrowingEntity borrowing = new BorrowingEntity();
        borrowing.setBook(booksService.getBook(bookId));
        borrowing.setCustomer(customersService.getCustomerById(customerId));
        return borrowingRepository.save(borrowing);
    }

    //get borrowing by id
    public BorrowingEntity getBorrowingById(Long borrowingId) {
        Optional<BorrowingEntity> borrowing = borrowingRepository.findById(borrowingId);
        return borrowing.orElse(null);
    }

    //delete borrowing
    public void deleteBorrowing(Long borrowingId){ borrowingRepository.deleteById(borrowingId); }
}

package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static githubmagovia.vzorovyprojekt.kniznica.BooksController.books;
import static githubmagovia.vzorovyprojekt.kniznica.CustomersController.customers;

@RestController
public class BorrowingsController {
    private final List<Borrowing> borrowings;
    
    public BorrowingsController(){
        this.borrowings = init();
    }

    private List<Borrowing> init() { return new ArrayList<>(); }

    //get list of borrowings
    @GetMapping("/api/borrowings")
    public List<Borrowing> getAllBorrowings() { return this.borrowings; }

    //post borrowing
    @PostMapping("/api/borrowings")
    public void createBook(@RequestBody BorrowingRequest request) {
        Borrowing borrowing = new Borrowing();
        borrowing.setBook(books.get(request.bookId));
        borrowing.setBorrower(customers.get(request.customerId));
        borrowing.setId(borrowings.size());
        this.borrowings.add(borrowing);
    }

    //get borrowing by id
    @GetMapping("api/borrowings/{borrowingId}")
    public Borrowing getBorrowing(@PathVariable Integer borrowingId) { return this.borrowings.get(borrowingId); }

    //delete borrowing
    @DeleteMapping("api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){
        decrementIds(borrowingId);
        this.borrowings.remove(this.borrowings.get(borrowingId));
    }

    //decrement id of borrowing
    private void decrementIds(int id) {
        int size = borrowings.size();
        int borrowingID = id + 1;
        while (borrowingID < size) { borrowings.get(borrowingID++).decrementId(); }
    }
}

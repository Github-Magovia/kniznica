package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {

    private List<Borrowing> borrowings;
    
    public BorrowingsController(){
        this.borrowings = init();
    }

    private List<Borrowing> init(){
        this.borrowings = new ArrayList<>();
        Borrowing Borrowing1 = new Borrowing();

        Borrowing1.setId(8);
        Borrowing1.setCustomerId(0);
        Borrowing1.setCustomerName("Janko Veľký");
        Borrowing1.setBookId(0);
        Borrowing1.setAuthorName("J.R.R Tolkien");
        Borrowing1.setTitle("Harry");

        borrowings.add(Borrowing1);

        Borrowing Borrowing2 = new Borrowing();

        Borrowing2.setId(2);
        Borrowing2.setCustomerId(1);
        Borrowing2.setCustomerName("Janko Veľký");
        Borrowing2.setBookId(1);
        Borrowing2.setAuthorName("J.R.R Tolkien");
        Borrowing2.setTitle("Harry");

        borrowings.add(Borrowing2);


        return borrowings;
    }

    //get list of borrowings
    @GetMapping("/api/borrowings")
    public List<Borrowing> getAllBorrowings(@RequestParam(required = false) String title) {
        if(title == null) {
            return this.borrowings;
        }
        List<Borrowing> filteredBorrowings = new ArrayList<>();
        for (Borrowing borrowings : borrowings) {
            if (borrowings.getTitle().equals(title)){
                filteredBorrowings.add(borrowings);
            }
        }
        return filteredBorrowings;

    }
    //post borrowing
    @PostMapping("/api/borrowings")
    public void createBook(@RequestBody Borrowing borrowing) {
        borrowing.setId(borrowings.size());
        this.borrowings.add(borrowing);
    }

    //get borrowing by id
    @GetMapping("api/borrowings/{borrowingId}")
    public Borrowing getBorrowing(@PathVariable Integer borrowingId){
        return this.borrowings.get(borrowingId);
    }

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

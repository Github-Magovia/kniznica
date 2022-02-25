package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowingsController {
    private final BorrowingService borrowingService;

    public BorrowingsController(BorrowingService borrowingService) { this.borrowingService = borrowingService; }

    //get list of borrowings
    @GetMapping("/api/borrowing")
    public List<Borrowing> getBorrowings() { return borrowingService.getBorrowings(); }

    //get list of formatted borrowings
    @GetMapping("/api/borrowings")
    public List<BorrowingBody> getBorrowingBodies() { return borrowingService.getBorrowingBodies(); }

    //post borrowing
    @PostMapping("/api/borrowings")
    public Integer createBorrowing(@RequestBody Borrowing request) { return borrowingService.createBorrowing(request); }

    //get borrowing by id
    @GetMapping("api/borrowings/{borrowingId}")
    public BorrowingBody getBorrowing(@PathVariable Integer borrowingId) { return borrowingService.getBorrowing(borrowingId); }

    //delete borrowing
    @DeleteMapping("api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){ borrowingService.deleteBorrowing(borrowingId); }
}

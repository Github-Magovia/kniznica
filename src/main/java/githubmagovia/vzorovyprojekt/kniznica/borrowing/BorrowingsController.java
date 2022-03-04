package githubmagovia.vzorovyprojekt.kniznica.borrowing;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BorrowingsController {
    private final BorrowingService borrowingService;

    public BorrowingsController(BorrowingService borrowingService) { this.borrowingService = borrowingService; }

    //get list of borrowings
    @GetMapping("/api/borrowings")
    public List<BorrowingDto> getBorrowings() {
        List<BorrowingEntity> entities = borrowingService.getBorrowings();
        List<BorrowingDto> result = new ArrayList<>();
        for (BorrowingEntity entity : entities) { result.add(mapToDto(entity)); }
        return result;
    }

    //post borrowing
    @PostMapping("/api/borrowings")
    public BorrowingEntity createBorrowing(@RequestBody Long bookId, Long customerId) {
        return borrowingService.createBorrowing(bookId, customerId);
    }

    //get borrowing by id
    @GetMapping("api/borrowings/{borrowingId}")
    public BorrowingDto getBorrowingById(@PathVariable Integer borrowingId) {
        return mapToDto(borrowingService.getBorrowingById(borrowingId));
    }

    //delete borrowing
    @DeleteMapping("api/borrowings/{borrowingId}")
    public void deleteBorrowing(@PathVariable Integer borrowingId){ borrowingService.deleteBorrowing(borrowingId); }

    //maps BorrowingEntity into BorrowingDto
    private BorrowingDto mapToDto(BorrowingEntity entity) {
        BorrowingDto borrowingDto = new BorrowingDto();
        BookEntity book = borrowing.getBook();
        CustomersEntity customer = borrowing.getCustomer();
        borrowingDto.setId(borrowing.getId());
        borrowingDto.setCustomerId(customer.getId());
        borrowingDto.setCustomerName(customer.getFirstName() + " " + customer.getLastName());
        borrowingDto.setBookId(book.getId());
        borrowingDto.setAuthorName(book.getAuthorFirstName() + " " + book.getAuthorLastName());
        borrowingDto.setTitle(book.getTitle());
        return borrowingDto;
    }
}

package githubmagovia.vzorovyprojekt.kniznica.borrowing;

public class Borrowing {
    private Long customerId;
    private Long bookId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}

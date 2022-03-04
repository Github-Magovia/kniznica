package githubmagovia.vzorovyprojekt.kniznica.borrowing;

public class BorrowingBody {
    private int id;
    private int customerId;
    private String customerName;
    private int bookId;
    private String authorName;
    private String title;

    public BorrowingBody(Borrowing b) {
        this.id = b.getId();
        this.customerId = b.getCustomerId();
        this.bookId = b.getBookId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

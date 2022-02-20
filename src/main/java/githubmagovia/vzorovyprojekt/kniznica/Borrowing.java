package githubmagovia.vzorovyprojekt.kniznica;

public class Borrowing {
    public int id;
    private int customerId;
    private int bookId;
    private String customerName;
    private String authorName;
    private String title;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public int getBookId() { return bookId; }

    public void setBookId(int id) { this.bookId = id; }

    public void decrementId() {
        this.id--;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int id) {
        this.customerId = id;
    }

    public void setId(int id) { this.id = id;}

    public int getId() { return id;}


}

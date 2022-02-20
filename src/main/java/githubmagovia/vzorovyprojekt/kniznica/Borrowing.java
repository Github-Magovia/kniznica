package githubmagovia.vzorovyprojekt.kniznica;

public class Borrowing {
    private int id;
    private Book book;
    private Customers borrower;

    public void setId(int id) { this.id = id;}

    public int getId() { return id; }

    public void decrementId() { this.id--; }

    public Book getBook() { return book; }

    public void setBook(Book book) { this.book = book; }

    public Customers getBorrower() { return borrower; }

    public void setBorrower(Customers borrower) { this.borrower = borrower; }
}

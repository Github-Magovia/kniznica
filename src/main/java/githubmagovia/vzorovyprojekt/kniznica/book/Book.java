package githubmagovia.vzorovyprojekt.kniznica.book;

@Deprecated
public class Book {
    private String title;
    private String isbn;
    private String authorFirstName;
    private String authorLastName;
    private int bookCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAuthorFirstName() { return authorFirstName; }

    public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }

    public String getAuthorLastName() { return authorLastName; }

    public void setAuthorLastName(String authorLastName) { this.authorLastName = authorLastName; }

    public int getBookCount() { return bookCount; }

    public void setBookCount(int bookCount) { this.bookCount = bookCount; }
}

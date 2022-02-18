package githubmagovia.vzorovyprojekt.kniznica;

public class Book {
    private Long id;
    private String name;
    private String isbn;
    private String authorFirstName;
    private String authorLastName;
    private int bookCount;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAuthorFirstName() { return authorFirstName; }

    public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }

    public String getAuthorLastName() { return authorLastName; }

    public void setAuthorLastName(String authorLastName) { this.authorLastName = authorLastName; }

    public int getBookCount() { return bookCount; }

    public void setBookCount(int bookCount) { this.bookCount = bookCount; }
}

package githubmagovia.vzorovyprojekt.kniznica;

import java.util.ArrayList;
import java.util.List;

public class BooksController {
    private List<Book> books;

    public BooksController() { this.books = init(); }

    private List<Book> init() { return new ArrayList<>(); }

}

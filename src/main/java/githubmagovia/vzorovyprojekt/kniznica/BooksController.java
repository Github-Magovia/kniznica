package githubmagovia.vzorovyprojekt.kniznica;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    public static List<Book> books;

    public BooksController() { books = init(); }

    private List<Book> init() { return new ArrayList<>(); }

    //Create new book title
    @PostMapping("/api/books")
    public void createBook(@RequestBody Book book) {
        book.setId(books.size());
        books.add(book);
    }

    //List all book titles
    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String name) {
        if (name == null) { return books; }
        List<Book> filteredList = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().equals(name)) { filteredList.add(book); }
        }
        return filteredList;
    }

    //Get book title by id
    @GetMapping("/api/books/{id}")
    public Book getBook(@PathVariable Integer id) { return books.get(id); }

    //Update book title
    @PutMapping("/api/books/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        Book changed = books.get(id);
        changed.setName(book.getName());
        changed.setIsbn(book.getIsbn());
        changed.setAuthorFirstName(book.getAuthorFirstName());
        changed.setAuthorLastName(book.getAuthorLastName());
        changed.setBookCount(book.getBookCount());
        return changed;
    }

    //Delete book title
    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        decrementIds(id);
        books.remove(id.intValue());
    }

    //Decrement id of every book in the list after the removed book
    private void decrementIds(int id) {
        int size = books.size();
        int bookId = id + 1;
        while (bookId < size) { books.get(bookId++).decrementId(); }
    }
}

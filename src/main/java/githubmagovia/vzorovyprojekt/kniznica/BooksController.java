package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    //Create
    @PostMapping("/api/books")
    public void createBook(@RequestBody Book book) {
        booksService.createBook(book);
    }

    //Get - all
    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String name) {
        return booksService.getBooks(name);
    }

    //Get - by id
    @GetMapping("/api/books/{id}")
    public Book getBook(@PathVariable Integer id) { return booksService.getBook(id); }

    //Update
    @PutMapping("/api/books/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        return booksService.updateBook(id,book);
    }

    //Delete
    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        booksService.deleteBook(id);
    }

}

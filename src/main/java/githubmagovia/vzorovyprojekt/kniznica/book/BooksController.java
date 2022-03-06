package githubmagovia.vzorovyprojekt.kniznica.book;

import githubmagovia.vzorovyprojekt.kniznica.Customers;
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
    public BookEntity bookEntity(@RequestBody Book book) {
        return booksService.createBook(book);
    }

    //Get - all
    @GetMapping("/api/books")
    public List<BookDto> getAllBooks(@RequestParam(required = false) String name) {
        List<BookEntity> entities = booksService.getAllBooks(name);
        List<BookDto> result = new ArrayList<>();
        for(BookEntity entity : entities){
            result.add(mapToDto(entity));
        }
        return result;
    }

    //Get - by id
    @RequestMapping ("/api/books/{bookId}")
    public BookDto getBookById(@PathVariable Long bookId) { return mapToDto(booksService.getBookById(bookId)); }

    //Update
    @PutMapping("/api/books/{id}")
    public void updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        booksService.updateBook(bookId,book);
    }

    //Delete
    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long bookId) {
        booksService.deleteBook(bookId);
    }

    private BookDto mapToDto(BookEntity entity){
        BookDto bookDto = new BookDto();
        bookDto.setId(entity.getId());
        bookDto.setName(entity.getName());
        bookDto.setIsbn(entity.getIsbn());
        bookDto.setAuthorFirstName(entity.getAuthorFirstName());
        bookDto.setAuthorLastName(entity.getAuthorLastName());
        bookDto.setBookCount(entity.getBookCount());
        return bookDto;
    }

}


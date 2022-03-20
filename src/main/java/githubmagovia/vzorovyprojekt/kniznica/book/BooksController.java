package githubmagovia.vzorovyprojekt.kniznica.book;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    //Create - POST
    @PostMapping("/api/books")
    public BookEntity createBook(@RequestBody BookDto book) {
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
    @GetMapping ("/api/books/{bookId}")
    public BookDto getBookById(@PathVariable Long bookId) { return mapToDto(booksService.getBookById(bookId)); }

    //Update
    @PutMapping("/api/books/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto book) {
        return mapToDto(booksService.updateBook(id,book));
    }

    //Delete
    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
    }

    private BookDto mapToDto(BookEntity entity){
        BookDto bookDto = new BookDto();
        bookDto.setId(entity.getId());
        bookDto.setTitle(entity.getTitle());
        bookDto.setAuthorFirstName(entity.getAuthorFirstName());
        bookDto.setAuthorLastName(entity.getAuthorLastName());
        bookDto.setName(entity.getAuthorFirstName() + " " + entity.getAuthorLastName());
        bookDto.setIsbn(entity.getIsbn());
        bookDto.setBookCount(entity.getBookCount());
        return bookDto;
    }
}


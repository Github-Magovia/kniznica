package githubmagovia.vzorovyprojekt.kniznica.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BookRepository bookRepository;


    public BooksService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    private List<Book> init() { return new ArrayList<>(); }

    //Create
    public BookEntity createBook(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(book.getName());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setAuthorFirstName(book.getAuthorFirstName());
        bookEntity.setAuthorLastName(book.getAuthorLastName());
        bookEntity.setBookCount(book.getBookCount());
        return this.bookRepository.save(bookEntity);
    }

    //Get - all
    public List<BookEntity> getAllBooks(String name) {
        List<BookEntity> full = bookRepository.findAll();
        if (name == null) { return full; }
        List<BookEntity> filteredList = new LinkedList<>();
        for (BookEntity b : full) {
            if(name.equals(b.getName())){
                filteredList.add(b);
            }
        }
        return filteredList;
    }

    //Get - by id
    public BookEntity getBookById(Long bookId) {
        Optional<BookEntity> book = bookRepository.findById(bookId);
        return book.orElse(null);
    }


    //Update
    public void updateBook(Long bookId,Book book) {
       Optional<BookEntity> b = bookRepository.findById(bookId);
        if(b.isPresent()){
            b.get().setName(book.getName());
            b.get().setIsbn(book.getIsbn());
            b.get().setAuthorFirstName(book.getAuthorFirstName());
            b.get().setAuthorLastName(book.getAuthorLastName());
            b.get().setBookCount(book.getBookCount());
        }
    }

    //Delete
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }


}

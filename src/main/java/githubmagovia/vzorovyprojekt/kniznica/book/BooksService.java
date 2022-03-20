package githubmagovia.vzorovyprojekt.kniznica.book;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BookRepository bookRepository;

    public BooksService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    //Create
    public BookEntity createBook(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setAuthorFirstName(book.getAuthorFirstName());
        bookEntity.setAuthorLastName(book.getAuthorLastName());
        bookEntity.setBookCount(book.getBookCount());
        return this.bookRepository.save(bookEntity);
    }

    //Get - all
    public List<BookEntity> getAllBooks(String title) {
        List<BookEntity> full = bookRepository.findAll();
        if (title == null) { return full; }
        List<BookEntity> filteredList = new LinkedList<>();
        for (BookEntity b : full) {
            if(title.equals(b.getTitle())){
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
    public BookEntity updateBook(Long bookId,BookDto book) {
        Optional<BookEntity> b = bookRepository.findById(bookId);
        if(b.isPresent()){
            b.get().setTitle(book.getTitle());
            b.get().setIsbn(book.getIsbn());
            b.get().setAuthorFirstName(book.getAuthorFirstName());
            b.get().setAuthorLastName(book.getAuthorLastName());
            b.get().setBookCount(book.getBookCount());
            bookRepository.save(b.get());
            return b.get();
        }
        return null;
    }

    //Delete
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }


}


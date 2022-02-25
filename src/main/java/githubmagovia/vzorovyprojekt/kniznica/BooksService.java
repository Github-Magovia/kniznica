package githubmagovia.vzorovyprojekt.kniznica;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {
    private int idCounter = 0;
    private final List<Book> books;

    public BooksService() { books = init(); }

    private List<Book> init() { return new ArrayList<>(); }

    //Create
    public void createBook(Book book) {
        book.setId(idCounter++);
        books.add(book);
    }

    //Get - all
    public List<Book> getBooks(String name) {
        if (name == null) { return books; }
        List<Book> filteredList = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().equals(name)) { filteredList.add(book); }
        }
        return filteredList;
    }

    //Get - by id
    public Book getBook(Integer id) { return findBook(id); }


    //Update
    public Book updateBook(Integer id,Book book) {
        Book b = findBook(id);
        if(b!= null){
            b.setName(book.getName());
            b.setIsbn(book.getIsbn());
            b.setAuthorFirstName(book.getAuthorFirstName());
            b.setAuthorLastName(book.getAuthorLastName());
            b.setBookCount(book.getBookCount());
        }
        return b;
    }

    //Delete
    public void deleteBook(Integer id) {
        books.remove(findBook(id));
    }


    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) { return b; }
        }
        return null;
    }

}

package githubmagovia.vzorovyprojekt.kniznica.borrowing;

import javax.persistence.*;

@Entity
public class BorrowingEntity {
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn
    @ManyToOne
    private BookEntity book;

    @JoinColumn
    @ManyToOne
    private CustomersEntity customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {
        this.customer = customer;
    }
}

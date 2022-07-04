package home.proj.BookStore.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String bookSerialNumber;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Double price;

@ManyToMany()
@JoinTable(
        name = "books_publisher",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "publisher_id")
)
private Set<Publisher> publishers;
public Set<Publisher> getPublishers(){
    return publishers;
}
    @ManyToMany()
    @JoinTable(
            name = "books_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors;
    public Set<Author> getAuthors(){
        return authors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return bookId != null && Objects.equals(bookId, book.bookId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

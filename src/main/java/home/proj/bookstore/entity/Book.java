package home.proj.bookstore.entity;


import lombok.*;
import javax.persistence.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "isbn", nullable = false)
    private String bookSerialNumber;
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Column(name = "price", nullable = false)
    private Double price;


@ManyToMany()
@JoinTable(
        name = "books_publisher",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "publisher_id")
)
@ToString.Exclude
private Set<Publisher> publishers;
    @ManyToMany()
    @JoinTable(
            name = "books_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @ToString.Exclude
    private Set<Author> authors;


}

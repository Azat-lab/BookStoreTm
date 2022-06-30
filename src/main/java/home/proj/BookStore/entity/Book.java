package home.proj.BookStore.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    @Column
    private String title;

    @Column(name = "isbn")
    private String bookSerialNumber;
    @Column
    private Integer amount;
    @Column
    private Double price;

}

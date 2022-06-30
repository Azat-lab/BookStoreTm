package home.proj.BookStore.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "full_name")
    private String fullName;
    private Double rating;

}

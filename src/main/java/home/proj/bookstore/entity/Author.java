package home.proj.bookstore.entity;


import lombok.*;
import org.hibernate.Hibernate;


import javax.persistence.*;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "rating")
    private Double rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Author author = (Author) o;
        return authorId != null && Objects.equals(authorId, author.authorId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

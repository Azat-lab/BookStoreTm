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
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id")
    private Long publishId;
    @Column(name = "org_name")
    private String organizationName;
    @Column(name = "address")
    private String address;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Publisher publisher = (Publisher) o;
        return publishId != null && Objects.equals(publishId, publisher.publishId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

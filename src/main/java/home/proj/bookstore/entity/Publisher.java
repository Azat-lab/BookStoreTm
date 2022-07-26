package home.proj.bookstore.entity;


import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publishId;
    @Column(name = "org_name")
    private String organizationName;
    @Column(name = "address")
    private String address;

}

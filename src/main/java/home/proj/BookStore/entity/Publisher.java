package home.proj.BookStore.entity;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id")
    private Integer publishId;
    @Column(name = "org_name")
    private String organizationName;
    @Column(name = "address")
    private String address;

}

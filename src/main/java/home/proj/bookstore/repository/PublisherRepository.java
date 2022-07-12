package home.proj.bookstore.repository;

import home.proj.bookstore.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findByAddress(String address);

    List<Publisher> findByOrganizationName(String organizationName);





}

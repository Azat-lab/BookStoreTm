package home.proj.BookStore.repository;

import home.proj.BookStore.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    List<Publisher> findByAddress(String address);

    List<Publisher> findByOrganizationName(String organizationName);
}

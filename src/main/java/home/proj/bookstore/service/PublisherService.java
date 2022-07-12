package home.proj.bookstore.service;

import home.proj.bookstore.entity.Publisher;


import java.util.List;
import java.util.Optional;

public interface PublisherService {

    Optional<Publisher> findByPublishId(Long publishId);
    List<Publisher> findAllPublishers();
    List<Publisher> findByAddress(String address);
    List<Publisher> findByOrganizationName(String organizationName);
    void deleteByPublishId(Long publishId);
    void savePublisher(Publisher publisher);
}

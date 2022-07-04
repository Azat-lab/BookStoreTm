package home.proj.BookStore.service;

import home.proj.BookStore.entity.Publisher;


import java.util.List;
import java.util.Optional;

public interface PublisherService {

    Optional<Publisher> findByPublishId(Long publishId);
    List<Publisher> findAll();
    List<Publisher> findByAddress(String address);
    List<Publisher> findByOrganizationName(String organizationName);
    void deleteByPublishId(Long publishId);
    void savePublisher(Publisher publisher);
}

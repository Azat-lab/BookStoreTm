package home.proj.BookStore.service;

import home.proj.BookStore.entity.Publisher;


import java.util.List;
import java.util.Optional;

public interface PublisherService {

    Optional<Publisher> findByPublishId(Integer publishId);
    Iterable<Publisher> findAll();
    List<Publisher> findByAddress(String address);
    List<Publisher> findByOrganizationName(String organizationName);
    void deleteByPublishId(Integer publishId);
    void save(Publisher publisher);
}

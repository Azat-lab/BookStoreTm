package home.proj.bookstore.service;

import home.proj.bookstore.entity.Publisher;


import java.util.List;

public interface PublisherService {

    Publisher findByPublishId(Long publishId);
    List<Publisher> findAllPublishers();
    List<Publisher> findByAddress(String address);
    List<Publisher> findByOrganizationName(String organizationName);
    void deletePublisher(Long publishId);
    void savePublisher(Publisher publisher);
}

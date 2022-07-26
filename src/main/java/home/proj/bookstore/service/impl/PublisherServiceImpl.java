package home.proj.bookstore.service.impl;

import home.proj.bookstore.entity.Publisher;
import home.proj.bookstore.repository.PublisherRepository;
import home.proj.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher findByPublishId(Long publishId) {
        return this.publisherRepository.findById(publishId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Publisher> findAllPublishers() {
        return this.publisherRepository.findAll();
    }

    @Override
    public List<Publisher> findByAddress(String address) {
        return this.publisherRepository.findByAddress(address);
    }

    @Override
    public List<Publisher> findByOrganizationName(String organizationName) {
        return this.publisherRepository.findByOrganizationName(organizationName);
    }

    @Override
    public void deletePublisher(Long publishId) {
        this.publisherRepository.deleteById(publishId);

    }
    @Override
    public void savePublisher(Publisher publisher) {
        final var publisherToSave = Publisher.builder()
                .address(publisher.getAddress())
                .organizationName(publisher.getOrganizationName())
                .build();

        this.publisherRepository.save(publisherToSave);
    }
}

package home.proj.bookstore.service;

import home.proj.bookstore.entity.Publisher;
import home.proj.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Optional<Publisher> findByPublishId(Long publishId) {
        return publisherRepository.findById(publishId);
    }

    @Override
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> findByAddress(String address) {
        return publisherRepository.findByAddress(address);
    }

    @Override
    public List<Publisher> findByOrganizationName(String organizationName) {
        return publisherRepository.findByOrganizationName(organizationName);
    }

    @Override
    public void deleteByPublishId(Long publishId) {
        publisherRepository.deleteById(publishId);

    }
    @Override
    public void savePublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }
}

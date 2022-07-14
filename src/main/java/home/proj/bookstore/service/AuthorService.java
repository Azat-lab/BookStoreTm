package home.proj.bookstore.service;

import home.proj.bookstore.entity.Author;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {
    List<Author> findAllAuthors();
    Optional<Author> findByAuthorId(Long authorId);
    void deleteByAuthorId(Long authorId);
    void saveAuthor(Author author);


}

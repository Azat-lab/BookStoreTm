package home.proj.BookStore.service;

import home.proj.BookStore.entity.Author;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {
    List<Author> findAll();
    Optional<Author> findByAuthorId(Long authorId);
    void deleteByAuthorId(Long authorId);
    void saveAuthor(Author author);

}

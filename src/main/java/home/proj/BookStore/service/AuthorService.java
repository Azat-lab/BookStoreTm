package home.proj.BookStore.service;

import home.proj.BookStore.entity.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuthorService {
    Optional<Author> findByAuthorId(Integer authorId);
    Iterable<Author> findAll();
    void deleteAuthorById(Integer authorId);
    Author saveAuthor(Author author);
}

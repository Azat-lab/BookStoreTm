package home.proj.bookstore.service;

import home.proj.bookstore.entity.Author;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface AuthorService {
    List<Author> findAllAuthors();
    Author findByAuthorId(Long authorId);
    void deleteByAuthorId(Long authorId);
    Author saveAuthor(Author author);


}
//    List<Author> findByName(String author);
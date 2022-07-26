package home.proj.bookstore.service.impl;

import home.proj.bookstore.entity.Author;
import home.proj.bookstore.repository.AuthorRepository;
import home.proj.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findByAuthorId(Long authorId) {
        return this.authorRepository.findById(authorId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteByAuthorId(Long authorId) {
        this.authorRepository.deleteById(authorId);
    }
    @Override
    public Author saveAuthor(Author author) {
        final var authorToSave = Author.builder()
                .fullName(author.getFullName())
                .rating(author.getRating())
                .build();
        return this.authorRepository.save(authorToSave);
    }
}

//    @Override
//    public List<Author> findByName(String author) {
//        return authorRepository.findBy(author);
//    }

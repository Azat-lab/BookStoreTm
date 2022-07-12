package home.proj.bookstore.service;

import home.proj.bookstore.entity.Author;
import home.proj.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService{


    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findByAuthorId(Long authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public void deleteByAuthorId(Long authorId) {
        authorRepository.deleteById(authorId);
    }
    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }


}

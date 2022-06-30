package home.proj.BookStore.service;

import home.proj.BookStore.entity.Author;
import home.proj.BookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Optional<Author> findByAuthorId(Integer authorId) {
        return authorRepository.findById(authorId);
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteAuthorById(Integer authorId) {
        authorRepository.deleteById(authorId);

    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
}

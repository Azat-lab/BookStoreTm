package home.proj.BookStore.service;

import home.proj.BookStore.entity.Author;
import home.proj.BookStore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findByAuthorId(Long authorId) {
        return authorRepository.findById((long) Math.toIntExact(authorId));
    }

    @Override
    public void deleteByAuthorId(Long authorId) {
        authorRepository.deleteById((long) Math.toIntExact(authorId));
    }
    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }


}

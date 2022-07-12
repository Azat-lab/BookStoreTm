package home.proj.bookstore.service;

import home.proj.bookstore.entity.Book;


import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findByBookId(Long bookId);
    void deleteByBookId(Long bookId);
    void saveBook(Book book);
    void updateBook(Book book);
    List<Book> findAll();

}

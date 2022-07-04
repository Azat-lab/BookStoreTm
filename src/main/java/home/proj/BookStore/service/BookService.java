package home.proj.BookStore.service;

import home.proj.BookStore.entity.Book;


import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findByBookId(Long bookId);
    void deleteByBookId(Long bookId);
    void saveBook(Book book);
    void updateBook(Book book);
    List<Book> findAll();

}

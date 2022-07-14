package home.proj.bookstore.service;

import home.proj.bookstore.entity.Book;
import home.proj.bookstore.service.impl.BookServiceImpl;


import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findByBookId(Long bookId);
    void deleteByBookId(Long bookId);
    void saveBook(Book book) throws BookServiceImpl.BooksAlreadyExistsException;
    void updateBook(Book book);
    List<Book> findAllBooks();


}

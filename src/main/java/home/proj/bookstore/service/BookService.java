package home.proj.bookstore.service;

import home.proj.bookstore.entity.Book;


import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    Book saveBook(Book book);
    Book findByBookId(Long bookId);
    void deleteByBookId(Long bookId);
    Book updateBook(Book book);

    List<Book> getBookByBookSerialNumber(String bookSerialNumber);

    List<Book> getBookByTitle();


}

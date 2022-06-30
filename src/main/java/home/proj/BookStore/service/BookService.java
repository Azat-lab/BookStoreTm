package home.proj.BookStore.service;

import home.proj.BookStore.entity.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface BookService {

    Optional<Book> findByBookId(Integer bookId);
    void deleteByBookId(Integer bookId);
    void saveBook(Book book);

    void updateBook(Book book);

}

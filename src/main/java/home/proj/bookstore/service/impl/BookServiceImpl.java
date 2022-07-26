package home.proj.bookstore.service.impl;


import home.proj.bookstore.entity.Book;
import home.proj.bookstore.repository.BookRepository;
import home.proj.bookstore.service.BookService;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book findByBookId(Long bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(EntityNotFoundException::new);

    }
    @Override
    public void deleteByBookId(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }

    public Book updateBook(Book book) {
        final var bookToSave = Book.builder()
                .title(book.getTitle())
                .bookSerialNumber(book.getBookSerialNumber())
                .amount(book.getAmount())
                .price(book.getPrice()).build();

            return this.bookRepository.save(bookToSave);
        }

    @Override
    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book)  {
        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getBookByBookSerialNumber(String bookSerialNumber) {
        return Collections.emptyList();
    }

    @Override
    public List<Book> getBookByTitle() {
        return Collections.emptyList();
    }

}


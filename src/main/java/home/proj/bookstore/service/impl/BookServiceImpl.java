package home.proj.bookstore.service.impl;


import home.proj.bookstore.entity.Book;
import home.proj.bookstore.repository.BookRepository;
import home.proj.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Optional<Book> findByBookId(Long bookId) {
        return bookRepository.findById(bookId);

    }
    @Override
    public void deleteByBookId(Long bookId) {
        bookRepository.deleteById(bookId);
    }
    @Override
    public void saveBook(Book book) throws BooksAlreadyExistsException {
        if(bookRepository.existsById(book.getBookId())){
            throw new BooksAlreadyExistsException();
        }
        bookRepository.save(book);
    }
    public void updateBook(Book book) {
        Optional<Book> bookFound = bookRepository.findById(book.getBookId());
        if (bookFound.isPresent()) {
            Book bookUpdate = bookFound.get();
            bookUpdate.setTitle(book.getTitle());
            bookUpdate.setBookSerialNumber(book.getBookSerialNumber());
            bookUpdate.setAmount(book.getAmount());
            bookUpdate.setPrice(book.getPrice());

            bookRepository.save(book);
        }
    }
    @Override
    public List<Book> findAllBooks() {
        return  bookRepository.findAll();
    }

    public static class BooksAlreadyExistsException extends Exception {
    }
}


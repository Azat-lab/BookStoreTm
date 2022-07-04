package home.proj.BookStore.service;


import home.proj.BookStore.entity.Book;
import home.proj.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Optional<Book> findByBookId(Long bookId) {
        return bookRepository.findById((long) Math.toIntExact(bookId));

    }
    @Override
    public void deleteByBookId(Long bookId) {
        bookRepository.deleteById((long) Math.toIntExact(bookId));
    }
    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }
    public void updateBook(Book book) {
        Optional<Book> bookFound = bookRepository.findById((long) Math.toIntExact(book.getBookId()));

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
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}


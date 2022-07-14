package home.proj.bookstore.controller;

import home.proj.bookstore.entity.Book;

import home.proj.bookstore.service.BookService;
import home.proj.bookstore.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = new ArrayList<>(bookService.findAllBooks());
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> findByBookId(@PathVariable("bookId") Long bookId) {
        Optional<Book> bookData = bookService.findByBookId(bookId);
        return bookData.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) throws BookServiceImpl.BooksAlreadyExistsException {
            bookService.saveBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @DeleteMapping("/{bookId}")
            public ResponseEntity<HttpStatus> deleteByBookId(@PathVariable("bookId") Long bookId){
        try {
            bookService.deleteByBookId(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
            bookService.updateBook(book);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
}



package home.proj.BookStore.controller;

import home.proj.BookStore.entity.Book;
import home.proj.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(value = "/books/find/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) {
        Optional<Book> bookData = bookService.findByBookId(bookId);
        return bookData.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/books/save")
    public ResponseEntity<Book> createBook(@RequestBody @Validated Book book){
        try {
            bookService.saveBook(book);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
    @DeleteMapping(value = "books/delete/{bookId}")
            public ResponseEntity<HttpStatus> deleteByBookId(@PathVariable("bookId") Integer bookId){
        try{
            bookService.deleteByBookId(bookId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping(value = "books/updateBooks")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        try {
            bookService.updateBook(book);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}


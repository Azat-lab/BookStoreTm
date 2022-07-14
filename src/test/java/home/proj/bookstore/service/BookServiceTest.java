package home.proj.bookstore.service;

import home.proj.bookstore.entity.Book;
import home.proj.bookstore.repository.BookRepository;
import home.proj.bookstore.service.impl.BookServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Autowired
    @InjectMocks
    private BookServiceImpl service;

    private Book book1;
    private Book book2;
    List<Book> bookList;

    @BeforeEach
    public void setUp(){
        bookList = new ArrayList<>();
        book1 = new Book();
        book2 = new Book();
        bookList.add(book1);
        bookList.add(book2);
    }
    @AfterEach
    public void tearDown(){
        book1 = book2 = null;
        bookList = null;
    }

    @Test
    void givenBookToSaveShouldReturnSavedBook() {

        when(bookRepository.save(any())).thenReturn(book1);
        try {
            service.saveBook(book1);
        } catch (BookServiceImpl.BooksAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
        verify(bookRepository, times(1)).save(any());
    }

    @Test
    void GivenFindAllBooksShouldReturnListOfAllBooks(){
        bookRepository.save(book1);
        when(bookRepository.findAll()).thenReturn(bookList);
        List<Book> bookList1 =service.findAllBooks();
        assertEquals(bookList1,bookList);
        verify(bookRepository,times(1)).save(book1);
        verify(bookRepository,times(1)).findAll();
    }

    }
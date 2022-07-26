package home.proj.bookstore.service;

import home.proj.bookstore.entity.Book;
import home.proj.bookstore.repository.BookRepository;
import home.proj.bookstore.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Random;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;
    @InjectMocks
    private BookServiceImpl service;



    @Test
    void shouldSaveOneBook(){
        final var bookToSave = Book.builder().title("Multi Colour Design")
                .bookSerialNumber("95575585541")
                .amount(25)
                .price(45.25)
                .build();
        when(repository.save(any(Book.class))).thenReturn(bookToSave);

        final var actual = service.saveBook(new Book());

        assertThat(actual).usingRecursiveComparison().isEqualTo(bookToSave);
        verify(repository, times(1)).save(any(Book.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    void shouldFindAndReturnBook(){
        final var expectedBook = Book.builder().bookId(4L).title("Lord of the Rings")
                .bookSerialNumber("889977544781")
                .amount(15)
                .price(100.10)
                .build();
        when(repository.findById(anyLong())).thenReturn(Optional.of(expectedBook));

        final var actual = service.findByBookId(expectedBook.getBookId());

        assertThat(actual).usingRecursiveComparison().isEqualTo(expectedBook);
        verify(repository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(repository);

    }

    @Test
    void shouldNotFoundABookThatDoesntExists(){
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> service.findByBookId(getRandomLong()));
        verify(repository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void shouldFindAndReturnAllBooks(){
        when(repository.findAll()).thenReturn(List.of(new Book(), new Book()));

        assertThat(service.findAllBooks()).hasSize(2);
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void shouldDeleteBook(){
        doNothing().when(repository).deleteById(anyLong());

        service.deleteByBookId(getRandomLong());
        verify(repository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
    }
    private long getRandomLong(){
        return new Random().ints(1,10).findFirst().getAsInt();

    }

}


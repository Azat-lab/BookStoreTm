package home.proj.bookstore.service;



import home.proj.bookstore.entity.Author;
import home.proj.bookstore.repository.AuthorRepository;
import home.proj.bookstore.service.impl.AuthorServiceImpl;

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
class AuthorServiceTest {

    @Mock
    private AuthorRepository repository;

    @InjectMocks
    private AuthorServiceImpl service;

    @Test
    void shouldSaveAuthor(){
        final var authorToSave = Author.builder()
                .fullName("Ray Bradbury")
                .rating(4.7)
                .build();
        when(repository.save(any(Author.class))).thenReturn(authorToSave);

        final var actual = service.saveAuthor(new Author());

        assertThat(actual).usingRecursiveComparison().isEqualTo(authorToSave);
        verify(repository, times(1)).save(any(Author.class));
        verifyNoMoreInteractions(repository);
    }
    @Test
    void shouldNotFoundAuthorThatDoesntExists(){
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> service.findByAuthorId(getRandomLong()));
        verify(repository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(repository);
    }
    @Test
    void shouldFindAndReturnAllAuthors(){
        when(repository.findAll()).thenReturn(List.of(new Author(), new Author()));

        assertThat(service.findAllAuthors()).hasSize(2);
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void shouldDeleteAuthor(){
        doNothing().when(repository).deleteById(anyLong());

        service.deleteByAuthorId(getRandomLong());
        verify(repository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
    }

    private long getRandomLong(){
        return new Random().ints(1,10).findFirst().getAsInt();

    }


}
//    List<Author> findAllAuthors();
//    Author findByAuthorId(Long authorId);
//    void deleteByAuthorId(Long authorId);
//    Author saveAuthor(Author author);
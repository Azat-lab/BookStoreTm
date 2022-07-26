package home.proj.bookstore.service;



import home.proj.bookstore.entity.Publisher;
import home.proj.bookstore.repository.PublisherRepository;
import home.proj.bookstore.service.impl.PublisherServiceImpl;
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
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class PublisherServiceTest {

    @Mock
    private PublisherRepository repository;

    @InjectMocks
    private PublisherServiceImpl service;

    @Test
    void shouldSavePublisher(){
        final var publisherToSave = Publisher.builder()
                .organizationName("AST")
                .address("St. Agustin library")
                .build();
        when(repository.save(any(Publisher.class))).thenReturn(publisherToSave);

        final var actual = service.savePublisher(new Publisher());

        assertThat(actual).usingRecursiveComparison().isEqualTo(publisherToSave);
        verify(repository, times(1)).save(any(Publisher.class));
        verifyNoMoreInteractions(repository);
    }
    @Test
    void shouldNotFoundPublisherThatDoesntExists(){
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Assertions.assertThrows(EntityNotFoundException.class, () -> service.findByPublishId(getRandomLong()));
        verify(repository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(repository);
    }
    @Test
    void shouldFindAndReturnAllPublishers(){
        when(repository.findAll()).thenReturn(List.of(new Publisher(), new Publisher()));

        assertThat(service.findAllPublishers()).hasSize(2);
        verify(repository, times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }
    @Test
    void shouldDeletePublisher(){
        doNothing().when(repository).deleteById(anyLong());

        service.deletePublisher(getRandomLong());
        verify(repository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
    }

    private long getRandomLong(){
        return new Random().ints(1,10).findFirst().getAsInt();

    }

}
package home.proj.bookstore.controller;

import home.proj.bookstore.entity.Author;
import home.proj.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/author")
public class AuthorController {


    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors() {
        List<Author> author = new ArrayList<>(authorService.findAllAuthors());
        if (author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
    @GetMapping("/{authorId}")
    public ResponseEntity<Author> findByAuthorId(@PathVariable("authorId") Long authorId) {
        Optional<Author> authorData = Optional.ofNullable(authorService.findByAuthorId(authorId));
        return authorData.map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody @Validated Author author){
            authorService.saveAuthor(author);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping( "/{authorId}")
    public ResponseEntity<HttpStatus> deleteByAuthorId(@PathVariable("authorId") Long authorId){
        try {
            authorService.deleteByAuthorId(authorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}


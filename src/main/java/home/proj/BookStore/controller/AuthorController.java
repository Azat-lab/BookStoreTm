package home.proj.BookStore.controller;

import home.proj.BookStore.entity.Author;
import home.proj.BookStore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> author = new ArrayList<Author>(authorService.findAll());
        if (author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
    @GetMapping("/author/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("authorId") Long authorId) {
        Optional<Author> authorData = authorService.findByAuthorId(authorId);
        return authorData.map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value ="/author/save")
    public ResponseEntity<Author> saveAuthor(@RequestBody @Validated Author author){
        try {
            authorService.saveAuthor(author);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping(value = "author/delete/{authorId}")
    public ResponseEntity<HttpStatus> deleteAuthorById(@PathVariable("authorId") Long authorId){
        try{
            authorService.deleteByAuthorId(authorId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

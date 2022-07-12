package home.proj.bookstore.controller;



import home.proj.bookstore.entity.Publisher;
import home.proj.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/publisher")
public class PublisherController {
    private final PublisherService publisherService;
    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> findAllPublishers() {
        List<Publisher> publisher = new ArrayList<>(publisherService.findAllPublishers());
        if (publisher.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @GetMapping( "/{publishId}")
    public ResponseEntity<Publisher> findPublisherById(@PathVariable Long publishId) {
        Optional<Publisher> publisherData = publisherService.findByPublishId(publishId);
        return publisherData.map(publisher -> new ResponseEntity<>(publisher, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody @Validated Publisher publisher){
            publisherService.savePublisher(publisher);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/organizationName")
    public ResponseEntity<List<Publisher>> findByOrganizationName(){
            List<Publisher> publisher = publisherService.findByOrganizationName("");
            if (publisher.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
    @GetMapping("/address")
    public ResponseEntity<List<Publisher>> findByAddress(){
            List<Publisher> publisher = publisherService.findByAddress(" ");
            if(publisher.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return  new ResponseEntity<>(publisher, HttpStatus.OK);
    }
    @DeleteMapping("/{publishId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("publishId") Long publishId){
        try {
            publisherService.deleteByPublishId(publishId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

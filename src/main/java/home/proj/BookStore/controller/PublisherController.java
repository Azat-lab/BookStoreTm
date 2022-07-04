package home.proj.BookStore.controller;



import home.proj.BookStore.entity.Publisher;
import home.proj.BookStore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publisher")
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publisher = new ArrayList<Publisher>(publisherService.findAll());
        if (publisher.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }


    @GetMapping(value ="publisher/find/{publishId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long publishId) {
        Optional<Publisher> publisherData = publisherService.findByPublishId(publishId);
        return publisherData.map(publisher -> new ResponseEntity<>(publisher, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value ="/publisher/save")
    public ResponseEntity<Publisher> createPublisher(@RequestBody @Validated Publisher publisher){
        try {
            publisherService.savePublisher(publisher);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value ="/publisher/findOrganization")
    public ResponseEntity<List<Publisher>> findByOrganizationName(){
        try{
            List<Publisher> publisher = publisherService.findByOrganizationName("");
            if(publisher.isEmpty()){
                return new ResponseEntity<>(HttpStatus.CONTINUE);
            }
            return  new ResponseEntity<>(publisher, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value ="/publisher/address")
    public ResponseEntity<List<Publisher>> getByAddress(){
        try{
            List<Publisher> publisher = publisherService.findByAddress(" ");
            if(publisher.isEmpty()){
                return new ResponseEntity<>(HttpStatus.CONTINUE);
            }
            return  new ResponseEntity<>(publisher, HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping(value = "publisher/delete/{publishId}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("publishId") Long publishId){
        try{
            publisherService.deleteByPublishId(publishId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

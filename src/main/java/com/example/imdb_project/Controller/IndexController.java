package com.example.imdb_project.Controller;


import com.example.imdb_project.Service.IndexService;
import com.example.imdb_project.Service.IndexServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/movies")
public class IndexController {


    IndexService indexService = new IndexServiceImpl();
    @PostMapping
    public ResponseEntity indexAsync(@RequestBody MultipartFile akas, @RequestBody MultipartFile basics,
                                     @RequestBody MultipartFile crew, @RequestBody MultipartFile episode,
                                     @RequestBody MultipartFile principals, @RequestBody MultipartFile ratings) {
        if ((basics == null) || (akas == null) || (crew == null) || (episode == null) || (principals == null) ||
                (ratings == null)){
            return new ResponseEntity("Error in file", HttpStatus.BAD_REQUEST);
        }
        this.indexService.setReaders(akas,basics,crew,episode,principals,ratings);
        indexService.indexAsync(basics.getSize());
        return new ResponseEntity("File accepted (QUEUED)", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity indexCreation(){
        indexService.indexCreation();
        return new ResponseEntity("Index generated", HttpStatus.OK);
    }
}

package com.lesson;

import com.lesson.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @GetMapping(path="aliens", produces = {"application/json"})
    //@ResponseBody - *
    public List<Alien> getAliens(){
        List<Alien> aliens = repo.findAll();

        return aliens;
    }

    @GetMapping("alien/{id}")
    //@ResponseBody - replaced with RestController *
    public Optional<Alien> getAlien(@PathVariable("id") int id){
        return repo.findById(id);
    }

    @PostMapping(path="alien", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Alien addAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }
}

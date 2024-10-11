package com.project.SpringSecurity1.controllers;

import com.project.SpringSecurity1.models.Application;
import com.project.SpringSecurity1.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
public class AppController {
    private AppService service;

    @GetMapping("/page1")
    public String welcome(){
        return "Page is unprotected!";
    }

    @GetMapping("/applications")
    public List<Application> getAllApplicatins(){
        return service.allApplications();
    }

    @GetMapping("/application/{id}")
    public Application getApplicationById(@PathVariable("id") int id){
        return service.applicationById(id);
    }
}

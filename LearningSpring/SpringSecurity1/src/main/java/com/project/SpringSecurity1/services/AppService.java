package com.project.SpringSecurity1.services;

import com.github.javafaker.Faker;
import com.project.SpringSecurity1.models.Application;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class AppService {
    private List<Application> applications;

    @PostConstruct
    public void loadAppInDB(){
        Faker faker = new Faker();

        applications = IntStream.rangeClosed(1, 100)
                .mapToObj(el -> Application.builder()
                        .id(el)
                        .name(faker.name().toString())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();
    }

    public List<Application> allApplications(){
        return applications;
    }

    public Application applicationById(int id){
        return applications.stream().filter(el -> el.getId() == id).findFirst().orElse(null);
    }
}

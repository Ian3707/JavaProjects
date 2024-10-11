package com.lesson1;

import com.lesson1.config.AppConfig;
import com.lesson1.service.CourseService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class Main{
    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(Main.class, args);

        Alien alien = context.getBean(Alien.class);

        alien.code();
    }
}
package com.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    private int id;
    private String name;
    @Autowired
    Laptop laptop;

    public void code(){
        System.out.println("I'm coding...");
        laptop.compile();
    }
}

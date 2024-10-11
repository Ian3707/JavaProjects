package com.lesson;

public class Laptop implements Computer{
    @Override
    public void compile(){
        System.out.println("Compiling on laptop...");
    }
}

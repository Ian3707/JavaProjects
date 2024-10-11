package com.lesson;

public class Alien {
    private int age;
    private Computer pc;

    public Alien(){
        System.out.println("Object 'Alien' has been created");
    }

//    public Alien(int age, Laptop laptop) {
//        this.age = age;
//        this.laptop = laptop;
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setting age");
        this.age = age;
    }

    public Computer getPc() {
        return pc;
    }

    public void setPc(Computer pc) {
        this.pc = pc;
    }

    public void code(){
        System.out.println("Coding...");
        pc.compile();
    }
}

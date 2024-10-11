package com.lesson;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Main {
    public static void main(String[] args) {
//        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring.xml"));
//        Alien alien = (Alien) factory.getBean("alien");
//        alien.code();

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Alien alien = (Alien) context.getBean("alien");
//        alien.code();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Alien alien = (Alien) context.getBean("alien");
        alien.code();

        System.out.println(alien.getAge());
    }
}
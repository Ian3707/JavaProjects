package com.lesson.SpringJDBC1;

import com.lesson.SpringJDBC1.model.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbc1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbc1Application.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(1);
		alien1.setName("Bob");
		alien1.setTechnology("Java Spring");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);


		System.out.println(repo.getAll());
	}

}

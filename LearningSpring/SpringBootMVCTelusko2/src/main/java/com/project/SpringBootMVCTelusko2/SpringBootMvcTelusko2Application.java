package com.project.SpringBootMVCTelusko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootMvcTelusko2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootMvcTelusko2Application.class, args);


		ProductService service = context.getBean(ProductService.class);

		List<Product> products = service.getAllProducts();
		for(Product product : products){
			System.out.println(product);
		}

	}

}

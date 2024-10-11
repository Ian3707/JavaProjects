package com.project.SpringBootMVCTelusko3;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Aspect
//@Component
@RestController
public class ProductController {
    @Autowired
//    @Before("execution(public * com.project.Product.add()")
    ProductService service;

    //private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/productByName")
    public Product getProductByName(@RequestParam("name") String name){
        return service.getProduct(name);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id){
        return service.getProduct(id);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product){
        service.addProduct(product);
    }
}

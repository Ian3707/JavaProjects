package com.project.SpringBootMVCTelusko3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;
//    public void addProduct(Product product) {
////        products.add(product);
//        db.save(product);
//    }
//
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProduct(String name) {
        return repo.findByName(name);
    }

    public Optional<Product> getProduct(int id) {
        return repo.findById(id);
    }

    public void addProduct(Product product){
        repo.save(product);
    }
}

package com.project.SpringBootMVCTelusko2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
//
//    public Product getProduct(String name) {
//        for(Product product : products){
//            if(product.getName().equals(name)){
//                return product;
//            }
//        }
//
//        return null;
//    }

}

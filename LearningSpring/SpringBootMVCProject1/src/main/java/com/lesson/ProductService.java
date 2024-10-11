package com.lesson;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    List<Product> products = new ArrayList<>();
    ProductDAO db = new ProductDAO();

    public void addProduct(Product product) {
//        products.add(product);
        db.save(product);
    }

    public List<Product> getAllProducts() {
        return db.getAll();
    }

    public Product getProduct(String name) {
        for(Product product : products){
            if(product.getName().equals(name)){
                return product;
            }
        }

        return null;
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();
        List<Product> result = new ArrayList<>();

        for(Product product : products){
            String name = product.getName().toLowerCase();
            String type = product.getType().toLowerCase();
            String place = product.getPlace().toLowerCase();

            if(name.contains(str) ||
                    type.contains(str) ||
                    place.contains(str)){
                result.add(product);
            }
        }

        return result;
    }
}

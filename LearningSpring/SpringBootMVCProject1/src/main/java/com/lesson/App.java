package com.lesson;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ProductService service = new ProductService();

//        service.addProduct(new Product("Asus VivoBook", "Laptop", "Main table", 2021));
//        service.addProduct(new Product("Logitech G34", "Mouse", "Black table", 2025));
//        service.addProduct(new Product("Shure SRH840", "Black Headphones", "Main table", 2023));
//        service.addProduct(new Product("Mousepad", "Mousepad", "Black table", 2023));
//        service.addProduct(new Product("Xiaomi 34'", "Monitor", "Wall", 2024));
//        service.addProduct(new Product("Lamp", "Lamp", "Main table", 2021));
//        service.addProduct(new Product("Medicine", "Medicine", "Shelf", 2019));
//        service.addProduct(new Product("White Shirt", "Shirt", "Closet", 2020));
//        service.addProduct(new Product("Black Shirt", "Shirt", "Closet", 2023));
//        service.addProduct(new Product("Notes Sheet", "Sheet", "Shelf", 2026));
//        service.addProduct(new Product("Black Pen", "Pen", "Shelf", 2024));

        List<Product> products = service.getAllProducts();
        for(Product product : products){
            System.out.println(product);
        }
//
//        System.out.println("====================================");
//        System.out.println("Particular item:" + service.getProduct("Xiaomi 34'"));
//
//        System.out.println("====================================");
//        System.out.println("Particular text:");
//        List<Product> res = service.getProductWithText("black");
//        for(Product product : res){
//            System.out.println(product);
//        }
    }
}

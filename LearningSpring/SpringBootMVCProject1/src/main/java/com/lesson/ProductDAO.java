package com.lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Connection connection = null;

    public ProductDAO(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:7000/SpringMVCTeluskoProject1", "postgres", "aDwaqG1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product product) {
        String query = "insert into Product (name, type, place, warranty) values (?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setString(3, product.getPlace());
            statement.setInt(4, product.getWarranty());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        String query = "select name, type, place, warranty from Product";
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                products.add(new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}

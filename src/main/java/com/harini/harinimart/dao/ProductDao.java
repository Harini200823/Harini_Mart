package com.harini.harinimart.dao;

import com.harini.harinimart.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private String jdbcURL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private String jdbcUsername = "sa";
    private String jdbcPassword = "";

    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS products (id INT PRIMARY KEY, name VARCHAR(255), price DOUBLE);";
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products (id, name, price) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_PRODUCTS_SQL = "SELECT * FROM products;";

    public ProductDao() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try {
            Class.forName("org.h2.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                 Statement statement = connection.createStatement()) {
                
                statement.execute(CREATE_TABLE_SQL);

                ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM products;");
                if (rs.next() && rs.getInt(1) == 0) {
                    try (PreparedStatement pstmt = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
                        
                        Object[][] productsData = {
                            {201, "Wireless Bluetooth Headphones", 59.99},
                            {202, "Smart Fitness Watch", 89.99},
                            {203, "Portable Bluetooth Speaker", 34.50},
                            {204, "Wireless Ergonomic Mouse", 19.99},
                            {205, "Fast Power Bank 10000mAh", 24.99}
                        };

                        for (Object[] prod : productsData) {
                            pstmt.setInt(1, (Integer) prod[0]);
                            pstmt.setString(2, (String) prod[1]);
                            pstmt.setDouble(3, (Double) prod[2]);
                            pstmt.executeUpdate();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Class.forName("org.h2.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS_SQL);
                 ResultSet rs = preparedStatement.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");

                    String imageUrl;
                    double rating;

                    switch (id) {
                        case 201:
                            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=500&auto=format&fit=crop";
                            rating = 4.5;
                            break;
                        case 202:
                            imageUrl = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?q=80&w=500&auto=format&fit=crop";
                            rating = 4.3;
                            break;
                        case 203:
                            imageUrl = "https://images.unsplash.com/photo-1545454675-3531b543be5d?q=80&w=500&auto=format&fit=crop";
                            rating = 4.2;
                            break;
                        case 204:
                            imageUrl = "https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?q=80&w=500&auto=format&fit=crop";
                            rating = 4.0;
                            break;
                        case 205:
                            imageUrl = "https://images.unsplash.com/photo-1609091839311-d5365f9ff1c5?q=80&w=500&auto=format&fit=crop";
                            rating = 4.4;
                            break;
                        default:
                            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=500&auto=format&fit=crop";
                            rating = 4.0;
                    }

                    products.add(new Product(id, name, price, imageUrl, rating));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
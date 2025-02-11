package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://192.168.1.28:3306/item_management";
        String username = "item_user";
        String password = "securepassword123";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("✅ Connection successful!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
    }
}

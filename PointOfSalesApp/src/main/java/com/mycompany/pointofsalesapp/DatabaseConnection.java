package com.mycompany.pointofsalesapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/pointofsalesdb"; // Ganti dengan nama database Anda
            String user = "MYSQL"; // Ganti dengan username database Anda
            String password = "zidan123"; // Ganti dengan password database Anda
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

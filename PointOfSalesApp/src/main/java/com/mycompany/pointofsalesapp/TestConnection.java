package com.mycompany.pointofsalesapp;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        // Ubah getConnection() menjadi connect()
        Connection connection = DatabaseConnection.connect();
        
        if (connection != null) {
            System.out.println("Koneksi berhasil");
        } else {
            System.out.println("Koneksi gagal");
        }
    }
}

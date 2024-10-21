package com.mycompany.pointofsalesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserManagementForm extends JFrame {
    private JTextField usernameField, passwordField, roleField;
    private JButton tambahBtn, hapusBtn, ubahBtn, resetBtn;

    public UserManagementForm() {
        setTitle("Manajemen Pengguna");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        add(panel, BorderLayout.CENTER);

        // Input fields
        usernameField = new JTextField();
        passwordField = new JTextField();
        roleField = new JTextField();

        panel.add(new JLabel("Username"));
        panel.add(usernameField);
        panel.add(new JLabel("Password"));
        panel.add(passwordField);
        panel.add(new JLabel("Role"));
        panel.add(roleField);

        // Buttons
        tambahBtn = new JButton("Tambah");
        ubahBtn = new JButton("Ubah");
        hapusBtn = new JButton("Hapus");
        resetBtn = new JButton("Reset");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.add(tambahBtn);
        buttonPanel.add(ubahBtn);
        buttonPanel.add(hapusBtn);
        buttonPanel.add(resetBtn);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);

        // Action listeners untuk setiap tombol
        tambahBtn.addActionListener(e -> tambahUser());
        ubahBtn.addActionListener(e -> ubahUser());
        hapusBtn.addActionListener(e -> hapusUser());
        resetBtn.addActionListener(e -> resetFields());
    }

    // Fungsi untuk menambah pengguna
    private void tambahUser() {
        Connection connection = DatabaseConnection.connect();
        try {
            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usernameField.getText());
            preparedStatement.setString(2, passwordField.getText());
            preparedStatement.setString(3, roleField.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Pengguna berhasil ditambahkan");
            resetFields();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fungsi lainnya (ubahUser, hapusUser, resetFields) bisa ditulis dengan cara yang sama

    private void ubahUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void hapusUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void resetFields() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

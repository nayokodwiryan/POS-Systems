package com.mycompany.pointofsalesapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class DataUserForm extends JFrame {
    private JTextField usernameField, passwordField, roleField;
    private JButton tambahBtn, editBtn, deleteBtn, searchBtn, viewBtn, resetBtn;

    public DataUserForm() {
        setTitle("Data User - Modern Design");
        setSize(600, 400); // Ukuran lebih besar
        setLocationRelativeTo(null); // Posisikan di tengah
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setModernTheme(); // Menerapkan tema modern

        // Panel untuk input form
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(40, 44, 52)); // Background modern
        add(formPanel, BorderLayout.CENTER);
        placeComponents(formPanel);

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel(new GridLayout(1, 6, 10, 10));
        buttonPanel.setBackground(new Color(40, 44, 52)); // Background modern
        buttonPanel.add(tambahBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(resetBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Jarak antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label dan field Username
        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        usernameField = new JTextField(20);
        usernameField.setPreferredSize(new Dimension(200, 35)); // Ukuran lebih besar
        usernameField.setBackground(new Color(60, 63, 65)); // Warna modern
        usernameField.setForeground(Color.WHITE); // Teks putih
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1)); // Border halus
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        // Label dan field Password
        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);

        passwordField = new JTextField(20);
        passwordField.setPreferredSize(new Dimension(200, 35)); // Ukuran lebih besar
        passwordField.setBackground(new Color(60, 63, 65)); // Warna modern
        passwordField.setForeground(Color.WHITE);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Label dan field Role
        JLabel roleLabel = new JLabel("Role");
        roleLabel.setForeground(Color.WHITE);
        roleLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(roleLabel, gbc);

        roleField = new JTextField(20);
        roleField.setPreferredSize(new Dimension(200, 35)); // Ukuran lebih besar
        roleField.setBackground(new Color(60, 63, 65)); // Warna modern
        roleField.setForeground(Color.WHITE);
        roleField.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 1));
        gbc.gridx = 1;
        panel.add(roleField, gbc);

        // Tombol Tambah
        tambahBtn = createStyledButton("Tambah");
        editBtn = createStyledButton("Edit");
        deleteBtn = createStyledButton("Delete");
        searchBtn = createStyledButton("Search");
        viewBtn = createStyledButton("View Users");
        resetBtn = createStyledButton("Reset");

        // Listener untuk tombol
        tambahBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahUser();
            }
        });

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editUser();
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUser();
            }
        });

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewUsers();
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    // Membuat tombol dengan gaya modern
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(120, 35));
        button.setBackground(new Color(45, 136, 255)); // Warna biru modern
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(new Color(45, 136, 255), 2, true));

        // Efek hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 111, 230)); // Warna hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(45, 136, 255)); // Warna default
            }
        });

        return button;
    }

    // Tema modern untuk form
    private void setModernTheme() {
        UIManager.put("control", new Color(60, 63, 65));
        UIManager.put("text", new Color(230, 230, 230));
        UIManager.put("nimbusBase", new Color(50, 50, 50));
        UIManager.put("nimbusBlueGrey", new Color(60, 60, 60));
        UIManager.put("nimbusLightBackground", new Color(40, 44, 52));
    }

    // Fungsi Tambah User (Create)
    private void tambahUser() {
        Connection connection = DatabaseConnection.connect();
        try {
            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usernameField.getText());
            preparedStatement.setString(2, passwordField.getText());
            preparedStatement.setString(3, roleField.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "User berhasil ditambahkan!");
            resetFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saat menambahkan user");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fungsi Edit User (Update)
    private void editUser() {
        Connection connection = DatabaseConnection.connect();
        try {
            String query = "UPDATE users SET password = ?, role = ? WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, passwordField.getText());
            preparedStatement.setString(2, roleField.getText());
            preparedStatement.setString(3, usernameField.getText());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(null, "User tidak ditemukan!");
            }
            resetFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saat mengupdate user");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fungsi Delete User (Delete)
    private void deleteUser() {
        Connection connection = DatabaseConnection.connect();
        try {
            String query = "DELETE FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usernameField.getText());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "User tidak ditemukan!");
            }
            resetFields();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saat menghapus user");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fungsi Search User
    private void searchUser() {
        Connection connection = DatabaseConnection.connect();
        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usernameField.getText());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usernameField.setText(resultSet.getString("username"));
                passwordField.setText(resultSet.getString("password"));
                roleField.setText(resultSet.getString("role"));
            } else {
                JOptionPane.showMessageDialog(null, "User tidak ditemukan!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fungsi View Users
    private void viewUsers() {
        Connection connection = DatabaseConnection.connect();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Membuat JFrame untuk menampilkan data
            JFrame frame = new JFrame("View Users");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JTable table = new JTable(buildTableModel(resultSet));
            frame.add(new JScrollPane(table));
            frame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metode untuk membangun model tabel dari ResultSet
    private DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        Vector<String> columnNames = new Vector<>();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }

    // Fungsi Reset Fields
    private void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
        roleField.setText("");
    }

    public static void main(String[] args) {
        new DataUserForm();
    }
}

package com.mycompany.pointofsalesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductManagementForm extends JFrame {

    private JTextField searchField;
    private JTable productTable;
    private JButton addButton, deleteButton, searchButton;

    public ProductManagementForm() {
        setTitle("Product Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create and set up components
        JPanel topPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        searchButton = new JButton("Search");

        topPanel.add(new JLabel("Search Product:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        // Add product table
        String[] columns = {"Product ID", "Product Name", "Price"};
        Object[][] data = {  // Replace this with actual data from the database
            {1, "Product1", 10000},
            {2, "Product2", 20000},
            {3, "Product3", 30000}
        };
        productTable = new JTable(data, columns);

        JScrollPane tableScrollPane = new JScrollPane(productTable);

        // Add button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add Product");
        deleteButton = new JButton("Delete Product");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // Add components to the main frame
        add(topPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Add Product form
                new AddProductForm().setVisible(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle product deletion
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle search logic
            }
        });
    }

    private static class AddProductForm {

        public AddProductForm() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}

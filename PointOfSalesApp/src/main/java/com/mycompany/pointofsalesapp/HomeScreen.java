package com.mycompany.pointofsalesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {

    public HomeScreen() {
        setTitle("Home - Modern Design");
        setSize(600, 400);
        setLocationRelativeTo(null); // Memposisikan di tengah layar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Terapkan tema modern
        setModernDesign();

        // Panel utama dengan layout yang fleksibel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(40, 44, 52));  // Warna latar belakang modern
        add(panel);

        // Tempatkan komponen-komponen pada panel
        placeComponents(panel);

        setVisible(true);
    }

    // Mengatur penempatan komponen
    private void placeComponents(JPanel panel) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10); // Margin antara komponen
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        // Label utama
        JLabel label = new JLabel("Selamat datang di Point of Sales App", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(label, constraints);

        // Reset grid untuk menempatkan tombol-tombol di bawah label
        constraints.gridy++;
        constraints.gridwidth = 1;

        // Tombol Manage Users
        JButton manageUsersBtn = createStyledButton("Manage Users");
        panel.add(manageUsersBtn, constraints);

        // Tombol Manage Products
        constraints.gridx = 1;
        JButton manageProductsBtn = createStyledButton("Manage Products");
        panel.add(manageProductsBtn, constraints);

        // Event listener untuk tombol Manage Users
        manageUsersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DataUserForm();  // Membuka form DataUserForm
                dispose();  // Menutup layar Home
            }
        });

        // Event listener untuk tombol Manage Products
        manageProductsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tambahkan logika untuk membuka manajemen produk di sini
            }
        });
    }

    // Fungsi untuk membuat tombol dengan gaya modern
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 50));  // Ukuran tombol lebih besar
        button.setBackground(new Color(45, 136, 255));    // Warna biru flat modern
        button.setForeground(Color.WHITE);                // Warna teks putih
        button.setFocusPainted(false);                    // Menghilangkan border focus
        button.setFont(new Font("Roboto", Font.BOLD, 16));  // Font lebih besar dan tebal
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Mengubah kursor saat hover
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Border kosong untuk padding

        // Menambahkan sudut melengkung (rounded corners)
        button.setBorder(BorderFactory.createLineBorder(new Color(45, 136, 255), 2, true));

        // Efek hover (ganti warna tombol saat mouse hover)
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 111, 230));  // Warna saat hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(45, 136, 255));   // Kembali ke warna awal
            }
        });

        // Tambahkan bayangan (shadow) agar terlihat seperti tombol yang terangkat
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5),
            BorderFactory.createLineBorder(new Color(45, 136, 255), 1, true))
        );

        return button;
    }

    // Set modern dark theme untuk seluruh aplikasi
    private void setModernDesign() {
        UIManager.put("control", new Color(60, 63, 65));
        UIManager.put("text", new Color(230, 230, 230));
        UIManager.put("nimbusBase", new Color(50, 50, 50));
        UIManager.put("nimbusBlueGrey", new Color(60, 60, 60));
        UIManager.put("nimbusLightBackground", new Color(40, 44, 52));
    }

    public static void main(String[] args) {
        new HomeScreen();
    }
}

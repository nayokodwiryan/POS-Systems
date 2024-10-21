package com.mycompany.pointofsalesapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginBtn;

    public LoginForm() {
        setTitle("Login - Modern Design");
        setSize(400, 350); // Ukuran lebih besar
        setLocationRelativeTo(null); // Memposisikan di tengah
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Terapkan tema modern
        setModernTheme();

        // Panel utama dengan layout GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(40, 44, 52)); // Latar belakang modern gelap
        add(panel);

        // Tempatkan komponen-komponen pada panel
        placeComponents(panel);

        setVisible(true);
    }

    // Menempatkan komponen di panel dengan layout modern
    private void placeComponents(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margin antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL; // Memungkinkan elemen mengisi ruang secara horizontal

        // Label Username (ditempatkan di atas kotak)
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Lebar penuh
        panel.add(userLabel, gbc);

        // Field untuk memasukkan username (dengan border radius)
        usernameField = createRoundedTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Lebar penuh
        panel.add(usernameField, gbc);

        // Label Password (ditempatkan di atas kotak)
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Roboto", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Lebar penuh
        panel.add(passwordLabel, gbc);

        // Field untuk memasukkan password (dengan border radius)
        passwordField = createRoundedPasswordField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Lebar penuh
        panel.add(passwordField, gbc);

        // Tombol Login (dengan border radius)
        loginBtn = createStyledButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Mengatur tombol agar lebar penuh
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginBtn, gbc);

        // Action listener untuk login
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeScreen();
                dispose(); // Menutup jendela login
            }
        });
    }

    // Fungsi untuk membuat JTextField dengan border-radius
    private JTextField createRoundedTextField() {
        JTextField field = new JTextField(20) {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundedBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getBackground());
                    g2.fill(((RoundedBorder) getBorder()).getBorderShape(0, 0, getWidth(), getHeight()));
                    g2.dispose();
                }
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
                setOpaque(false);
                super.updateUI();
            }
        };
        field.setBackground(new Color(60, 63, 65)); // Warna field yang modern
        field.setForeground(Color.WHITE); // Teks putih
        field.setCaretColor(Color.WHITE); // Warna kursor teks
        field.setBorder(new RoundedBorder(15)); // Border dengan radius 15
        return field;
    }

    // Fungsi untuk membuat JPasswordField dengan border-radius
    private JPasswordField createRoundedPasswordField() {
        JPasswordField field = new JPasswordField(20) {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundedBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getBackground());
                    g2.fill(((RoundedBorder) getBorder()).getBorderShape(0, 0, getWidth(), getHeight()));
                    g2.dispose();
                }
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
                setOpaque(false);
                super.updateUI();
            }
        };
        field.setBackground(new Color(60, 63, 65)); // Warna field modern
        field.setForeground(Color.WHITE); // Teks putih
        field.setCaretColor(Color.WHITE); // Warna kursor teks
        field.setBorder(new RoundedBorder(15)); // Border dengan radius 15
        return field;
    }

    // Fungsi untuk membuat tombol bergaya modern dengan border-radius
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 40)); // Ukuran lebih besar dan proporsional
        button.setBackground(new Color(45, 136, 255)); // Warna biru flat modern
        button.setForeground(Color.WHITE); // Teks putih
        button.setFocusPainted(false); // Menghilangkan border saat di-focus
        button.setFont(new Font("Roboto", Font.BOLD, 16)); // Font modern
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor berubah saat hover
        button.setBorder(new RoundedBorder(20)); // Border dengan radius 20

        // Efek hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 111, 230)); // Warna hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(45, 136, 255)); // Warna asli
            }
        });

        return button;
    }

    // Menerapkan tema modern untuk aplikasi
    private void setModernTheme() {
        UIManager.put("control", new Color(60, 63, 65));
        UIManager.put("text", new Color(230, 230, 230));
        UIManager.put("nimbusBase", new Color(50, 50, 50));
        UIManager.put("nimbusBlueGrey", new Color(60, 60, 60));
        UIManager.put("nimbusLightBackground", new Color(40, 44, 52));
    }

    // Kelas untuk membuat border dengan radius
    class RoundedBorder extends AbstractBorder {
        private final int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(c.getForeground());
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        public Shape getBorderShape(int x, int y, int w, int h) {
            return new RoundRectangle2D.Double(x, y, w - 1, h - 1, radius, radius);
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
        }

        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = insets.top = insets.bottom = radius + 1;
            return insets;
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}

package com.mycompany.pointofsalesapp;

import javax.swing.SwingUtilities;

public class PointOfSalesApp {
    public static void main(String[] args) {
        // Menjalankan aplikasi pada Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}

package com.mycompany.pointofsalesapp;

import javax.swing.*;

public class ProfileForm extends JFrame {
    public ProfileForm() {
        setTitle("Profile");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("User Profile"));
        add(panel);

        setVisible(true);
    }
}

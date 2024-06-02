package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewOptionFrame extends JFrame {
    public ReviewOptionFrame() {
        // Set frame properties
        setTitle("Review Option");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);  // Center the frame on the screen

        // Create panel with GridBagLayout for center alignment
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Create JLabel
        JLabel label = new JLabel("WANT TO GIVE REVIEW?");
        gbc.insets = new Insets(20, 0, 0, 0); // Increase top inset for larger vertical distance
        panel.add(label, gbc);

        // Increment gridy for next component
        gbc.gridy++;

        // Create first JRadioButton
        JRadioButton radioButton1 = new JRadioButton("YES");
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReviewFrame rf = new ReviewFrame();
                rf.setVisible(true);
                dispose();
            }
        });

        // Create second JRadioButton
        JRadioButton radioButton2 = new JRadioButton("NO");
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionFrame2 op = new OptionFrame2();
                op.setVisible(true);
                dispose();
            }
        });

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        // Add buttons to the panel with spacing
        gbc.insets = new Insets(30, 0, 0, 0); // Increase top inset for larger vertical distance
        panel.add(radioButton1, gbc);

        gbc.gridy++;
        panel.add(radioButton2, gbc);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReviewOptionFrame frame = new ReviewOptionFrame();
            frame.setVisible(true);
        });
    }
}
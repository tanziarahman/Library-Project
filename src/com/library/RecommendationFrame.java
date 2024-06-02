package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecommendationFrame extends JFrame {
    public RecommendationFrame() {
        // Set frame properties
        setTitle("Recommendation");
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
        JLabel label = new JLabel("Would you like to recommend this book?");
        gbc.insets = new Insets(10, 0, 10, 0); // Add spacing around the label
        panel.add(label, gbc);

        // Create first JRadioButton
        JRadioButton radioButton1 = new JRadioButton("YES");
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecommendFrame lp = new RecommendFrame();
                lp.setVisible(true);
                dispose();
            }
        });

        // Create second JRadioButton
        JRadioButton radioButton2 = new JRadioButton("NO");
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionFrame2 m = new OptionFrame2();
                m.setVisible(true);
                dispose();
            }
        });

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        // Add buttons to the panel with spacing
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(radioButton1, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 10, 0);
        panel.add(radioButton2, gbc);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecommendationFrame frame = new RecommendationFrame();
            frame.setVisible(true);
        });
    }
}

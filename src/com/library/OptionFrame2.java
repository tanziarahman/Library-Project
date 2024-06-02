package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionFrame2 extends JFrame {
    public OptionFrame2() {
        // Set frame properties
        setTitle("Option");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 270);
        setLocationRelativeTo(null);  // Center the frame on the screen

        // Create panel with GridBagLayout for center alignment
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Create first JRadioButton
        JRadioButton radioButton1 = new JRadioButton("STAY LOGGED IN");
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionFrame pf = new OptionFrame();
                pf.setVisible(true);
                dispose();
            }
        });

        // Create second JRadioButton
        JRadioButton radioButton2 = new JRadioButton("BACK TO MAIN MENU");
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                dispose();
            }
        });

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        // Add buttons to the panel with spacing
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
            OptionFrame2 frame = new OptionFrame2();
            frame.setVisible(true);
        });
    }
}

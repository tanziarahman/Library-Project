package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionFrame extends JFrame {
    public OptionFrame() {
        setTitle("Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Create a panel with BoxLayout (Y_AXIS) for vertical alignment
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        // Create the radio buttons
        JRadioButton radioButton1 = new JRadioButton("BORROW");
        JRadioButton radioButton2 = new JRadioButton("RETURN");
        JRadioButton radioButton3 = new JRadioButton("SEARCH");

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        // Add the radio buttons to the panel
        radioPanel.add(radioButton1);
        radioPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between buttons
        radioPanel.add(radioButton2);
        radioPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between buttons
        radioPanel.add(radioButton3);

        // Add action listeners to the radio buttons
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrowFrame bf = new BorrowFrame();
                bf.setVisible(true);
                dispose();
                // Add your logic for BORROW action here
            }
        });

        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnFrame rf = new ReturnFrame();
                rf.setVisible(true);
                dispose();
                // Add your logic for RETURN action here
            }
        });

        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchFrame sf = new SearchFrame();
                sf.setVisible(true);
                dispose();
                // Add your logic for SEARCH action here
            }
        });
        // Add the radio panel to the main panel with GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(radioPanel, gbc);

        // Add main panel to content pane
        getContentPane().add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OptionFrame frame = new OptionFrame();
            frame.setVisible(true);
        });
    }
}

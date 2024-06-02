package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianOptionFrame extends JFrame {
    public LibrarianOptionFrame() {
        // Set frame properties
        setTitle("Button Group Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame on the screen

        // Create a panel with FlowLayout
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));

        // Create radio buttons
        JRadioButton button1 = new JRadioButton("ADD MEMBER");
        JRadioButton button2 = new JRadioButton("ADD BOOK");

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);

        // Add the buttons to the panel
        panel.add(button1);
        panel.add(button2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions for ADD MEMBER button
                LibrarianAddMemberFrame add = new LibrarianAddMemberFrame();
                add.setVisible(true);
                dispose();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibrarianAddBookFrame book = new LibrarianAddBookFrame();
                book.setVisible(true);
                dispose();
            }
        });

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibrarianOptionFrame frame = new LibrarianOptionFrame();
            frame.setVisible(true);
        });
    }
}

package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        // Set frame properties
        setTitle("Main Frame");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame on the screen

        // Create a main panel with BoxLayout (Y_AXIS) to align components vertically
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add some vertical glue (spacing) at the top
        mainPanel.add(Box.createVerticalGlue());

        // Create and add the JLabel
        JLabel label = new JLabel("*** BOOK KEEP ***");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(label);

        // Add some vertical spacing between components
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        // Create and add the first JButton
        JButton button1 = new JButton("SIGN IN");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(button1);

        // Add action listener to button1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserLogin u = new UserLogin();
                u.setVisible(true);
                dispose();
            }
        });

        // Add some vertical spacing between components
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Create and add the second JButton
        JButton button2 = new JButton("SIGN UP");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(button2);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewUserLoginFrame n = new NewUserLoginFrame();
                n.setVisible(true);
                dispose();
            }
        });

        // Add some vertical spacing between components
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Create and add the third JButton
        JButton button3 = new JButton("LIBRARIAN");
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(button3);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibrarianLoginFrame f = new LibrarianLoginFrame();
                f.setVisible(true);
                dispose();
            }
        });

        // Add some vertical glue (spacing) at the bottom
        mainPanel.add(Box.createVerticalGlue());

        // Add the main panel to the frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        Librarian.defaultBooks();
        Librarian.defaultLibraryMembers();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}

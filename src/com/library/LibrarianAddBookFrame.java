package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class LibrarianAddBookFrame extends JFrame {
    public LibrarianAddBookFrame() {
        // Set frame properties
        setTitle("Add New Book");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the frame on the screen

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Set GridBagConstraints properties for centering
        gbc.insets = new Insets(10, 10, 10, 10);  // Add padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Add vertical glue at the top for centering
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        panel.add(Box.createVerticalGlue(), gbc);

        // Add Name label and text field
        gbc.weighty = 0;
        JLabel nameLabel = new JLabel("BOOK TITLE:");
        JTextField nameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(nameField, gbc);

        // Add some vertical space
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridwidth = 1;

        // Add User ID label and text field
        JLabel userIdLabel = new JLabel("BOOK AUTHOR:");
        JTextField userIdField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(userIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(userIdField, gbc);

        // Add some vertical space
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridwidth = 1;

        // Add Password label and text field
        JLabel passwordLabel = new JLabel("QUANTITY:");
        JTextField passwordField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(passwordField, gbc);

        // Add some vertical space
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(Box.createVerticalStrut(10), gbc);

        gbc.gridwidth = 1;

        // Add the Submit button
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;  // Do not stretch the button
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("SUBMIT");
        panel.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Extract text from text fields
                String name = nameField.getText();
                String userId = userIdField.getText();
                String password = passwordField.getText();

                // Convert password to integer
                int quantity = Integer.parseInt(password);

                // Add book
                Librarian.addBook(name, userId, quantity);

                // Append data to file
                try (FileWriter file = new FileWriter("Books.txt", true)) {
                    file.append(name + "," + userId + "," + quantity + "\n");
                    file.close();
                    System.out.println("Data appended to Books.txt successfully.");
                } catch (IOException ex) {
                    System.out.println("Error appending data to Books.txt: " + ex.getMessage());
                }
                OptionFrame1 op1 = new OptionFrame1();
                op1.setVisible(true);
                dispose();
            }
        });

        // Add vertical glue at the bottom for centering
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weighty = 1;
        panel.add(Box.createVerticalGlue(), gbc);

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibrarianAddBookFrame frame = new LibrarianAddBookFrame();
            frame.setVisible(true);
        });
    }
}

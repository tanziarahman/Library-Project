package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianLoginFrame extends JFrame {
    public LibrarianLoginFrame() {
        setTitle("Librarian Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // First JLabel and JTextArea
        JLabel label1 = new JLabel(" LIBRARIAN ID:");
        JTextArea textArea1 = new JTextArea(1, 20);
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(label1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(scrollPane1, gbc);

        // Second JLabel and JTextArea
        JLabel label2 = new JLabel("PASSWORD:");
        JTextArea textArea2 = new JTextArea(1, 20);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(label2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(scrollPane2, gbc);

        // Add button
        JButton button = new JButton("OK");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Center the button horizontally
        gbc.fill = GridBagConstraints.NONE; // Allow the button to have its default size
        mainPanel.add(button, gbc);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String s = textArea1.getText();
                    int id = Integer.parseInt(s);
                    Librarian.checkCredentials(id,textArea2.getText());
                    LibrarianOptionFrame lf = new LibrarianOptionFrame();
                    lf.setVisible(true);
                    dispose();
                }
                catch(WrongCredentialsException w){
                    JOptionPane.showMessageDialog(null,w.getMessage(),"Wrong Credentials",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        getContentPane().add(mainPanel);

    }
}

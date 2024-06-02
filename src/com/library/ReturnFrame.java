package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnFrame extends JFrame {
    public ReturnFrame() {
        setTitle("Return");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // First JLabel and JTextArea
        JLabel label1 = new JLabel("YOUR ID:");
        JTextArea textArea1 = new JTextArea(1, 20);
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        mainPanel.add(label1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        mainPanel.add(scrollPane1, gbc);

        // Second JLabel and JTextArea
        JLabel label2 = new JLabel("BOOK TITLE:");
        JTextArea textArea2 = new JTextArea(1, 20);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(label2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(scrollPane2, gbc);

        // Third JLabel and JTextArea
        JLabel label3 = new JLabel("RETURN DATE:");
        JTextArea textArea3 = new JTextArea(1, 20);
        JScrollPane scrollPane3 = new JScrollPane(textArea3);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(label3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(scrollPane3, gbc);

        // Add button
        JButton button = new JButton("OK");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        gbc.fill = GridBagConstraints.NONE; // Use default button size
        mainPanel.add(button, gbc);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your logic here for the button click action
                String userId = textArea1.getText();
                int id = Integer.parseInt(userId);
                String bookTitle = textArea2.getText();
                String date = textArea3.getText();

                if(LibraryMember.returnBook(id,bookTitle,date)){
                    Book.removeFromBorrowList(id, bookTitle);
                    Book.addToStock(bookTitle);
                    int days = Book.totalBorrowDays(id, date, bookTitle);
                    int fine = Book.fine(days - 15);
                    if (days > 15) {
                        JOptionPane.showMessageDialog(null, "You have returned this book " + (days - 15) + " days late and you have been fined " + fine + " taka.", "Fine", JOptionPane.INFORMATION_MESSAGE);
                        OptionFrame2 op2 = new OptionFrame2();
                        op2.setVisible(true);
                        dispose();
                    } else if (days <= 15) {
                        JOptionPane.showMessageDialog(null, "You have returned the book: " + bookTitle, "Return", JOptionPane.INFORMATION_MESSAGE);
                        ReviewOptionFrame r = new ReviewOptionFrame();
                        r.setVisible(true);
                        dispose();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"This book was never borrowed","Error",JOptionPane.ERROR_MESSAGE);
                    OptionFrame2 op2 = new OptionFrame2();
                    op2.setVisible(true);
                    dispose();
                }
            }
        });

        // Add main panel to content pane
        getContentPane().add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReturnFrame frame = new ReturnFrame();
            frame.setVisible(true);
        });
    }
}

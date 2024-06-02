package com.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class RecommendFrame extends JFrame {
    public RecommendFrame(){
        setTitle("Recommend");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);  // Center the frame on the screen

        // Create panel with GridBagLayout for center alignment
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Create JLabel
        JLabel label = new JLabel("RECOMMEND:");
        panel.add(label, gbc);

        // Create JTextField with preferred height
        JTextField textField = new JTextField(15) {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.height = 30; // Set the preferred height
                return size;
            }
        };
        gbc.gridx++;
        gbc.insets = new Insets(0, 10, 0, 0); // Add padding between label and text field
        panel.add(textField, gbc);

        // Increment gridy for next component
        gbc.gridy++;

        // Create JButton
        JButton button = new JButton("OK");
        gbc.gridx = 0;
        gbc.gridwidth = 2; // Span across two columns
        gbc.insets = new Insets(10, 0, 0, 0); // Add padding between text field and button
        panel.add(button, gbc);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String s = textField.getText();
                    FileWriter r = new FileWriter("Recommendations.txt",true);
                    r.append(s + "\n");
                    r.close();
                    JOptionPane.showMessageDialog(null,"Your recommendation has been recorded","Recommendation",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (IOException f){
                    f.printStackTrace();
                }
                OptionFrame2 op = new OptionFrame2();
                op.setVisible(true);
                dispose();
            }
        });

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        RecommendFrame r = new RecommendFrame();
        r.setVisible(true);
    }
}

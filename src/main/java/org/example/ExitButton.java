package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {
    private final JFrame frame;

    public ExitButton(JFrame frame) {

        // Create 'Exit' button
        super("Exit");
        this.setBackground(Color.RED);
        this.setForeground(Color.WHITE);
        this.addActionListener(this);

        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Exit confirmation dialog
        int confirmExit = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmExit == JOptionPane.YES_OPTION) {

            // Exit program
            System.exit(0);
        }
    }
}

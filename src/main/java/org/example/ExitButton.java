package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {
    private JFrame frame;

    public ExitButton(JFrame frame) {

        // Create 'Exit' button
        super("Exit");
        this.addActionListener(this);

        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

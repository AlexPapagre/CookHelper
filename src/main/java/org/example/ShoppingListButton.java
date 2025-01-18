package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingListButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JList<String> fileList;

    public ShoppingListButton(JFrame frame, JList<String> fileList) {

        // Create 'Shopping List' button
        super("Shopping List");
        this.addActionListener(this);

        this.frame = frame;
        this.fileList = fileList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveRecipeButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JList<String> fileList;

    public RemoveRecipeButton(JFrame frame, JList<String> fileList) {

        // Create 'Remove Recipe' button
        super("Remove Recipe");
        this.addActionListener(this);

        this.frame = frame;
        this.fileList = fileList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

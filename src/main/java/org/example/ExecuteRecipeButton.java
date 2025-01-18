package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteRecipeButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JList<String> fileList;

    public ExecuteRecipeButton(JFrame frame, JList<String> fileList) {

        // Create 'Execute Recipe' button
        super("Execute Recipe");
        this.addActionListener(this);

        this.frame = frame;
        this.fileList = fileList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

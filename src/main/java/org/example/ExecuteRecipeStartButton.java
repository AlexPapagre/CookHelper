package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteRecipeStartButton extends JButton implements ActionListener {
    private final JDialog dialog;

    public ExecuteRecipeStartButton(JDialog dialog) {

        // Create 'Start' button
        super("Start");
        this.addActionListener(this);

        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Close execute recipe view
        dialog.dispose();

        // TODO CardLayout row 280
    }
}

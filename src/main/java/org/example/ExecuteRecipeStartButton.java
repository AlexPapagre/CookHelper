package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteRecipeStartButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JDialog dialog;
    private final RecipeModel model;

    public ExecuteRecipeStartButton(JFrame frame, JDialog dialog, RecipeModel model) {

        // Create 'Start' button
        super("Start");
        this.addActionListener(this);

        this.frame = frame;
        this.dialog = dialog;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Close execute recipe view
        dialog.dispose();

        // Execute Recipe Steps
        new ExecuteRecipeStepView(frame, model);
    }
}

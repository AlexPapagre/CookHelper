package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeView extends JDialog {

    public ExecuteRecipeView(JFrame frame, ExecuteRecipeModel model) {

        // Create execute recipe dialog
        super(frame, "Execute Recipe", true);
        this.setSize(600, 200);
        this.setLayout(new BorderLayout());

        // Add execute recipe start panel
        ExecuteRecipeStartPanel executeRecipeStartPanel = new ExecuteRecipeStartPanel(model.executeRecipeStart());
        this.add(executeRecipeStartPanel, BorderLayout.CENTER);

        // Add execute recipe button panel
        ExecuteRecipeButtonPanel executeRecipeButtonPanel = new ExecuteRecipeButtonPanel(frame, this, model);
        this.add(executeRecipeButtonPanel, BorderLayout.SOUTH);

        // Make execute recipe view visible
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}

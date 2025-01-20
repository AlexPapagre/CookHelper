package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeStepView extends JDialog {

    public ExecuteRecipeStepView(JFrame frame, ExecuteRecipeModel model) {

        // Create execute recipe step dialog
        super(frame, "Recipe Steps", true);
        this.setSize(1000, 600);
        this.setLayout(new BorderLayout());

        // Create execute recipe step panel progress bar
        JProgressBar executeRecipeStepPanelProgressBar = new JProgressBar(0, model.stepSize());
        executeRecipeStepPanelProgressBar.setValue(0);
        executeRecipeStepPanelProgressBar.setStringPainted(true);

        // Create execute recipe step panel text area
        JTextArea executeRecipeStepPanelTextArea = new JTextArea(model.executeRecipeStep(0));
        executeRecipeStepPanelTextArea.setEditable(false);
        executeRecipeStepPanelTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add execute recipe step panel
        ExecuteRecipeStepPanel executeRecipeStepPanel = new ExecuteRecipeStepPanel(executeRecipeStepPanelProgressBar, executeRecipeStepPanelTextArea);
        this.add(executeRecipeStepPanel, BorderLayout.CENTER);

        // Add execute recipe step button panel
        ExecuteRecipeStepButtonPanel executeRecipeStepButtonPanel = new ExecuteRecipeStepButtonPanel(frame, this, model, executeRecipeStepPanelProgressBar, executeRecipeStepPanelTextArea);
        this.add(executeRecipeStepButtonPanel, BorderLayout.SOUTH);

        // Make execute recipe step view visible
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}

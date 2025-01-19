package org.example;

import javax.swing.*;

public class ExecuteRecipeStepPanel extends JPanel {

    public ExecuteRecipeStepPanel(JProgressBar executeRecipeStepPanelProgressBar, JTextArea executeRecipeStepPanelTextArea) {

        // Add execute recipe step panel progress bar
        this.add(executeRecipeStepPanelProgressBar);

        // Add execute recipe step panel text area
        JScrollPane executeRecipeStepPanelTestAreaScrollPane = new JScrollPane(executeRecipeStepPanelTextArea);
        this.add(executeRecipeStepPanelTestAreaScrollPane);

        // Create execute recipe step panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}

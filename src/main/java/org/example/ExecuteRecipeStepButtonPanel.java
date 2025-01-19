package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeStepButtonPanel extends JPanel {

    public ExecuteRecipeStepButtonPanel(JFrame frame, JDialog dialog, RecipeModel model, JProgressBar progressBar, JTextArea textArea) {

        // Create execute recipe step button panel
        super(new FlowLayout(FlowLayout.CENTER));

        // Create execute recipe step button panel buttons
        ExecuteRecipeStepButtonPanelNextButton executeRecipeStepButtonPanelNextButton = new ExecuteRecipeStepButtonPanelNextButton(model, progressBar, textArea);
        ExecuteRecipeStepButtonPanelCountdownButton executeRecipeStepButtonPanelCountdownButton = new ExecuteRecipeStepButtonPanelCountdownButton(frame, model);
        executeRecipeStepButtonPanelNextButton.setCountdownButton(executeRecipeStepButtonPanelCountdownButton);
        executeRecipeStepButtonPanelCountdownButton.setNextButton(executeRecipeStepButtonPanelNextButton);
        CloseButton closeButton = new CloseButton(dialog);
        this.add(executeRecipeStepButtonPanelNextButton);
        this.add(executeRecipeStepButtonPanelCountdownButton);
        this.add(closeButton);
    }
}

package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeStepButtonPanel extends JPanel {
    private int i = 0;

    public ExecuteRecipeStepButtonPanel(JFrame frame, JDialog dialog, RecipeModel model, JProgressBar progressBar, JTextArea textArea) {

        // Create execute recipe step button panel
        super(new FlowLayout(FlowLayout.CENTER));

        // Create execute recipe step button panel buttons
        ExecuteRecipeStepButtonPanelNextButton executeRecipeStepButtonPanelNextButton = new ExecuteRecipeStepButtonPanelNextButton(model, progressBar, textArea, this);
        ExecuteRecipeStepButtonPanelCountdownButton executeRecipeStepButtonPanelCountdownButton = new ExecuteRecipeStepButtonPanelCountdownButton(frame, model, this);
        executeRecipeStepButtonPanelNextButton.setCountdownButton(executeRecipeStepButtonPanelCountdownButton);
        executeRecipeStepButtonPanelCountdownButton.setNextButton(executeRecipeStepButtonPanelNextButton);
        CloseButton closeButton = new CloseButton(dialog);
        this.add(executeRecipeStepButtonPanelNextButton);
        this.add(executeRecipeStepButtonPanelCountdownButton);
        this.add(closeButton);
    }

    public void increaseI() {
        i++;
    }

    public int getI() {
        return i;
    }
}

package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteRecipeStepButtonPanelNextButton extends JButton implements ActionListener {
    private final RecipeModel model;
    private final JProgressBar progressBar;
    private final JTextArea textArea;
    private final ExecuteRecipeStepButtonPanel stepIndex;
    private ExecuteRecipeStepButtonPanelCountdownButton countdownButton;

    public ExecuteRecipeStepButtonPanelNextButton(RecipeModel model, JProgressBar progressBar, JTextArea textArea, ExecuteRecipeStepButtonPanel stepIndex) {

        // Create 'Next' button
        super("Next");
        this.addActionListener(this);

        this.model = model;
        this.progressBar = progressBar;
        this.textArea = textArea;
        this.stepIndex = stepIndex;

        // Enable or disable next button based on if the step has countdown or not
        this.setEnabled(!model.stepHasTime(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        stepIndex.increaseI();
        int i = stepIndex.getI();
        if (model.stepExists(i)) {

            // Update progress bar and text area
            progressBar.setValue(i);
            textArea.setText(model.executeRecipeStep(i));

            // Enable or disable next and countdown buttons based on if the step has countdown or not
            if (model.stepHasTime(i)) {
                this.setEnabled(false);
                countdownButton.setEnabled(true);
            } else {
                this.setEnabled(true);
                countdownButton.setEnabled(false);
            }
        } else {

            // Finish progress bar and text area
            progressBar.setValue(100);
            textArea.setText("End of Recipe");

            // Disable next and countdown buttons
            this.setEnabled(false);
            countdownButton.setEnabled(false);
        }
    }

    public void setCountdownButton(ExecuteRecipeStepButtonPanelCountdownButton countdownButton) {
        this.countdownButton = countdownButton;
    }
}

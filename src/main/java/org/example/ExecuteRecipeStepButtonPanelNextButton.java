package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteRecipeStepButtonPanelNextButton extends JButton implements ActionListener {
    private final ExecuteRecipeModel model;
    private final JProgressBar progressBar;
    private final JTextArea textArea;
    private ExecuteRecipeStepButtonPanelCountdownButton countdownButton;

    public ExecuteRecipeStepButtonPanelNextButton(ExecuteRecipeModel model, JProgressBar progressBar, JTextArea textArea) {

        // Create 'Next' button
        super("Next");
        this.addActionListener(this);

        this.model = model;
        this.progressBar = progressBar;
        this.textArea = textArea;

        // Enable or disable next button based on if the step has countdown or not
        this.setEnabled(!model.stepHasTime(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.increaseIndex();
        int i = model.getIndex();
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
            textArea.setText("Τέλος Συνταγής.\n\nΚαλή σας όρεξη!");

            // Disable next and countdown buttons
            this.setEnabled(false);
            countdownButton.setEnabled(false);
        }
    }

    public void setCountdownButton(ExecuteRecipeStepButtonPanelCountdownButton countdownButton) {
        this.countdownButton = countdownButton;
    }
}

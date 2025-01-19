package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteRecipeStepButtonPanelCountdownButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final RecipeModel model;
    private final ExecuteRecipeStepButtonPanel stepIndex;
    private ExecuteRecipeStepButtonPanelNextButton nextButton;

    public ExecuteRecipeStepButtonPanelCountdownButton(JFrame frame, RecipeModel model, ExecuteRecipeStepButtonPanel stepIndex) {

        // Create 'Start Countdown' button
        super("Start Countdown");
        this.addActionListener(this);

        this.frame = frame;
        this.model = model;
        this.stepIndex = stepIndex;

        // Enable or disable countdown button based on if the step has countdown or not
        this.setEnabled(model.stepHasTime(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Enable next button
        nextButton.setEnabled(true);

        // Disable countdown button
        this.setEnabled(false);

        // Countdown
        new CountdownView(frame, model, stepIndex);
    }

    public void setNextButton(ExecuteRecipeStepButtonPanelNextButton nextButton) {
        this.nextButton = nextButton;
    }
}

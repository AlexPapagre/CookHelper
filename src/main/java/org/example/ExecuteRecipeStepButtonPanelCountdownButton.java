package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExecuteRecipeStepButtonPanelCountdownButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final ExecuteRecipeModel model;
    private ExecuteRecipeStepButtonPanelNextButton nextButton;

    public ExecuteRecipeStepButtonPanelCountdownButton(JFrame frame, ExecuteRecipeModel model) {

        // Create 'Start Countdown' button
        super("Start Countdown");
        this.addActionListener(this);

        this.frame = frame;
        this.model = model;

        // Enable or disable countdown button based on if the step has countdown or not
        this.setEnabled(model.stepHasTime(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Disable countdown button
        this.setEnabled(false);

        // Enable next button
        nextButton.setEnabled(true);

        // Countdown
        new CountdownView(frame, model);
    }

    public void setNextButton(ExecuteRecipeStepButtonPanelNextButton nextButton) {
        this.nextButton = nextButton;
    }
}

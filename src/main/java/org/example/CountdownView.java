package org.example;

import javax.swing.*;
import java.awt.*;

public class CountdownView extends JDialog {

    public CountdownView(JFrame frame, RecipeModel model, JLabel countdownLabel) {

        // Create countdown dialog
        super(frame, "Countdown Timer", true);
        this.setSize(300, 200);
        this.setLayout(new BorderLayout());

        // Add countdown panel
        JPanel countdownPanel = new JPanel();
        countdownPanel.setLayout(new BoxLayout(countdownPanel, BoxLayout.Y_AXIS));
        countdownPanel.add(countdownLabel);
        this.add(countdownPanel, BorderLayout.CENTER);

        // Add close button panel
        JPanel closeButtonPanel = new JPanel();
        closeButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        CloseButton closeButton = new CloseButton(this);
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.add(closeButton);
        this.add(closeButtonPanel, BorderLayout.SOUTH);

        // TODO build countdown form countdown factory
        // TODO add a timer that notifies every 1 second and refreshes label with Countdown's time left
        // TODO make a notifier for finishing the recipe and when the notifier action performed update label to "Time's up!"
        // TODO a new class with ActionListener every one second to print time left
        // TODO idea: anonimous class from cardlayout line 373 and instead of countdown[0] to have time left

        // Make countdown view visible
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}

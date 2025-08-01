package org.example;

import gr.hua.dit.oop2.countdown.Countdown;
import gr.hua.dit.oop2.countdown.CountdownFactory;

import javax.swing.*;
import java.awt.*;

public class CountdownView extends JDialog {

    public CountdownView(JFrame frame, ExecuteRecipeModel model) {

        // Create countdown dialog
        super(frame, "Countdown Timer", true);
        this.setSize(600, 200);
        this.setLayout(new BorderLayout());

        // Get step index
        int i = model.getIndex();

        // Add countdown panel
        JPanel countdownPanel = new JPanel();
        countdownPanel.setLayout(new BoxLayout(countdownPanel, BoxLayout.Y_AXIS));

        // Add countdown panel label
        JLabel countdownPanelLabel = new JLabel(Convertor.convertCountdownTime(model.stepSeconds(i)));
        countdownPanelLabel.setFont(new Font("Arial", Font.BOLD, 18));
        countdownPanelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        countdownPanel.add(countdownPanelLabel);
        this.add(countdownPanel, BorderLayout.CENTER);

        // Add close button panel
        JPanel closeButtonPanel = new JPanel();
        closeButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        CloseButton closeButton = new CloseButton(this);
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButtonPanel.add(closeButton);
        this.add(closeButtonPanel, BorderLayout.SOUTH);

        // Create and start countdown
        java.util.Timer timer = new java.util.Timer();
        Countdown countdown = CountdownFactory.countdown(model.stepSeconds(i));
        countdown.addNotifier(new NotifierImpl(timer, countdownPanelLabel));
        timer.schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                countdownPanelLabel.setText(Convertor.convertCountdownTime(countdown.secondsRemaining() + 1));
            }
        }, 1000, 500);
        countdown.start();

        // Make countdown view visible
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}

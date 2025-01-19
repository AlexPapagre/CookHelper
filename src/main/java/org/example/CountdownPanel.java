package org.example;

import javax.swing.*;

public class CountdownPanel extends JPanel {

    public CountdownPanel(JLabel countdownLabel) {

        // Add countdown label
        this.add(countdownLabel);

        // Create countdown panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}

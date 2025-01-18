package org.example;

import javax.swing.*;
import java.awt.*;

public class PeopleDialog extends JDialog {

    public PeopleDialog(JFrame frame, String file) {

        // Create people dialog
        super(frame, "People", true);
        this.setSize(300, 150);
        this.setLayout(new BorderLayout());

        // Create panel for input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        JLabel promptLabel = new JLabel("Please enter the amount of people:");
        promptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField integerField = new JTextField();
        integerField.setMaximumSize(new Dimension(200, 30));
        integerField.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(promptLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(integerField);
        this.add(inputPanel, BorderLayout.CENTER);

        // Add people button panel
        PeopleButtonPanel peopleButtonPanel = new PeopleButtonPanel(frame, this, file, integerField);
        this.add(peopleButtonPanel, BorderLayout.SOUTH);

        // Make people dialog visible
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}

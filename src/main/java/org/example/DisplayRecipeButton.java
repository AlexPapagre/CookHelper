package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayRecipeButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JList<String> fileList;

    public DisplayRecipeButton(JFrame frame, JList<String> fileList) {

        // Create 'Display Recipe' button
        super("Display Recipe");
        this.addActionListener(this);

        this.frame = frame;
        this.fileList = fileList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get selected file
        String selectedFile = fileList.getSelectedValue();

        if (selectedFile != null) {

            // Adding dialog to ask for amount of people
            PeopleDialog peopleDialog = new PeopleDialog(frame, selectedFile);
        } else {
            JOptionPane.showMessageDialog(frame, "No recipe selected to display!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        // Get selected files
        List<String> selectedFiles = fileList.getSelectedValuesList();

        if (selectedFiles.size() == 1) {

            // Adding dialog to ask for amount of people
            new PeopleDialog(frame, selectedFiles, "Display Recipe");
        } else if (selectedFiles.size() > 1) {
            JOptionPane.showMessageDialog(frame, "You can't display more than one recipe at the same time!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "No recipe selected to display!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

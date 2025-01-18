package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ExecuteRecipeButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JList<String> fileList;

    public ExecuteRecipeButton(JFrame frame, JList<String> fileList) {

        // Create 'Execute Recipe' button
        super("Execute Recipe");
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
            new PeopleDialog(frame, selectedFiles, "Execute Recipe");
        } else if (selectedFiles.size() > 1) {
            JOptionPane.showMessageDialog(frame, "You can't execute more than one recipe at the same time!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "No recipe selected to execute!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

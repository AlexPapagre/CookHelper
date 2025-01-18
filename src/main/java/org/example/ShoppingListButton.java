package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShoppingListButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JList<String> fileList;

    public ShoppingListButton(JFrame frame, JList<String> fileList) {

        // Create 'Shopping List' button
        super("Shopping List");
        this.addActionListener(this);

        this.frame = frame;
        this.fileList = fileList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get selected files
        List<String> selectedFiles = fileList.getSelectedValuesList();

        if (!selectedFiles.isEmpty()) {

            // Adding dialog to ask for amount of people
            new PeopleDialog(frame, selectedFiles, "Shopping List");
        } else {
            JOptionPane.showMessageDialog(frame, "No recipe selected to show shopping list!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

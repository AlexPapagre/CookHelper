package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectFilesButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final DefaultListModel<String> listModel;

    public SelectFilesButton(JFrame frame, DefaultListModel<String> listModel) {

        // Create 'Select Files' button
        super("Select Files");
        this.addActionListener(this);

        this.frame = frame;
        this.listModel = listModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Create the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for (File file : selectedFiles) {

                // Check if file is ".cook"
                if (file.getName().endsWith(".cook")) {
                    String fileWithPath = file.getName().replace(".cook", "") + " --> (" + file.getAbsolutePath() + ")";

                    // Check if the file is already in the list
                    if (listModel.contains(fileWithPath)) {
                        JOptionPane.showMessageDialog(frame, "File '" + file.getName() + "' is already in the list.", "Duplicate File", JOptionPane.WARNING_MESSAGE);
                    } else {
                        listModel.addElement(fileWithPath);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "File '" + file.getName() + "' is not a .cook file.", "Invalid File", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

}

package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import static org.example.Main.logger;

public class RemoveRecipesButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final DefaultListModel<String> listModel;
    private final JList<String> fileList;

    public RemoveRecipesButton(JFrame frame, DefaultListModel<String> listModel, JList<String> fileList) {

        // Create 'Remove Recipes' button
        super("Remove Recipes");
        this.addActionListener(this);

        this.frame = frame;
        this.listModel = listModel;
        this.fileList = fileList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get selected files
        List<String> selectedFiles = fileList.getSelectedValuesList();

        if (!selectedFiles.isEmpty()) {

            int confirmRemove = JOptionPane.showConfirmDialog(frame, "Are you sure you want to remove the selected " + (selectedFiles.size() == 1 ? "recipe" : "recipes") + "?", "Confirm Remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (confirmRemove == JOptionPane.YES_OPTION) {

                // Remove selected recipes from the list
                List<String> names = new LinkedList<>();
                for (String selectedFile : selectedFiles) {
                    listModel.removeElement(selectedFile);
                    names.add(Convertor.convertFileName(selectedFile));
                }
                logger.log("Remove Recipes: " + Convertor.convertNames(names.listIterator()));
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No recipe selected to remove!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

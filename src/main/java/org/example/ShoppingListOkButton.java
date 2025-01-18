package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import java.util.List;

public class ShoppingListOkButton extends OkButton {
    private final JFrame frame;
    private final JDialog dialog;
    private final List<String> files;
    private final JTextField integerField;

    public ShoppingListOkButton(JFrame frame, JDialog dialog, List<String> files, JTextField integerField) {
        this.frame = frame;
        this.dialog = dialog;
        this.files = files;
        this.integerField = integerField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Get amount of people
        String peopleInput = integerField.getText();
        try {
            int people = Integer.parseInt(peopleInput);

            if (people < 1) {
                throw new InputMismatchException();
            }

            // Close people dialog
            dialog.dispose();

            // Shopping List
            new ShoppingListView(frame, new ShoppingListModel(files, people));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nPlease enter a valid amount of people!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nThe amount of people can't be negative or zero!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

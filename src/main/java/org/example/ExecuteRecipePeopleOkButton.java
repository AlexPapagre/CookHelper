package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;

public class ExecuteRecipePeopleOkButton extends PeopleOkButton {
    private final JFrame frame;
    private final JDialog dialog;
    private final String file;
    private final JTextField integerField;

    public ExecuteRecipePeopleOkButton(JFrame frame, JDialog dialog, String file, JTextField integerField) {
        this.frame = frame;
        this.dialog = dialog;
        this.file = file;
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

            // Execute Recipe
            new ExecuteRecipeView(frame, new RecipeModel(file, people));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nPlease enter a valid amount of people!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nThe amount of people can't be negative or zero!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

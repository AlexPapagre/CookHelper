package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class DisplayRecipeOkButton extends JButton implements ActionListener {
    private final JFrame frame;
    private final JDialog dialog;
    private final String file;
    private final JTextField integerField;

    public DisplayRecipeOkButton(JFrame frame, JDialog dialog, String file, JTextField integerField) {

        // Create 'OK' button
        super("OK");
        this.addActionListener(this);

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

            // Display Recipe
            DisplayRecipeView displayRecipeView = new DisplayRecipeView(frame, new RecipeModel(file, people));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nPlease enter a valid amount of people!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nThe amount of people can't be negative or zero!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

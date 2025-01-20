package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.InputMismatchException;
import java.util.List;

import static org.example.Main.logger;

public class ShoppingListPeopleOkButton extends PeopleOkButton {
    private final JFrame frame;
    private final JDialog dialog;
    private final List<String> files;
    private final JTextField integerField;

    public ShoppingListPeopleOkButton(JFrame frame, JDialog dialog, List<String> files, JTextField integerField) {
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
            ShoppingListModel shoppingListModel = new ShoppingListModel(files, people);
            logger.log("Shopping List: " + shoppingListModel.getNames() + " for " + shoppingListModel.getPeople() + (shoppingListModel.getPeople() == 1 ? " person" : " people"));
            new ShoppingListView(frame, shoppingListModel);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nPlease enter a valid amount of people!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InputMismatchException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid input.\nThe amount of people can't be negative or zero!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

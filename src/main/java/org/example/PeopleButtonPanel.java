package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PeopleButtonPanel extends JPanel {

    public PeopleButtonPanel(JFrame frame, JDialog dialog, List<String> files, JTextField integerField, String button) {

        // Create people buttons
        OkButton okButton = null;
        if (button.equals("Display Recipe")) {
            okButton = new DisplayRecipeOkButton(frame, dialog, files.getFirst(), integerField);
        } else if (button.equals("Shopping List")) {
            okButton = new ShoppingListOkButton(frame, dialog, files, integerField);
        } else if (button.equals("Execute Recipe")) {
            okButton = new ExecuteRecipeOkButton(frame, dialog, files.getFirst(), integerField);
        }
        CloseButton closeButton = new CloseButton(dialog);

        // Create people button panel
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(okButton);
        this.add(closeButton);

    }
}

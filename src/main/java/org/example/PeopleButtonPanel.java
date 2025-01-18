package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PeopleButtonPanel extends JPanel {

    public PeopleButtonPanel(JFrame frame, JDialog dialog, List<String> files, JTextField integerField, String button) {

        // Create people buttons
        OkButton okButton = switch (button) {
            case "Display Recipe" -> new DisplayRecipeOkButton(frame, dialog, files.getFirst(), integerField);
            case "Shopping List" -> new ShoppingListOkButton(frame, dialog, files, integerField);
            case "Execute Recipe" -> new ExecuteRecipeOkButton(frame, dialog, files.getFirst(), integerField);
            default -> null;
        };
        CloseButton closeButton = new CloseButton(dialog);

        // Create people button panel
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(okButton);
        this.add(closeButton);

    }
}

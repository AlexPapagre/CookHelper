package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PeopleButtonPanel extends JPanel {

    public PeopleButtonPanel(JFrame frame, JDialog dialog, List<String> files, JTextField integerField, String button) {

        // Create people buttons
        PeopleOkButton peopleOkButton = switch (button) {
            case "Display Recipe" -> new DisplayRecipePeopleOkButton(frame, dialog, files.getFirst(), integerField);
            case "Shopping List" -> new ShoppingListPeopleOkButton(frame, dialog, files, integerField);
            case "Execute Recipe" -> new ExecuteRecipePeopleOkButton(frame, dialog, files.getFirst(), integerField);
            default -> null;
        };
        CloseButton closeButton = new CloseButton(dialog);

        // Create people button panel
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(peopleOkButton);
        this.add(closeButton);
    }
}

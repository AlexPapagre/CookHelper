package org.example;

import javax.swing.*;
import java.awt.*;

public class PeopleButtonPanel extends JPanel {

    public PeopleButtonPanel(JFrame frame, JDialog dialog, String file, JTextField integerField) {

        // Create people buttons
        DisplayRecipeOkButton displayRecipeOkButton = new DisplayRecipeOkButton(frame, dialog, file, integerField);
        CloseButton closeButton = new CloseButton(dialog);

        // Create people button panel
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(displayRecipeOkButton);
        this.add(closeButton);

    }
}

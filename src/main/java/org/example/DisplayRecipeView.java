package org.example;

import javax.swing.*;
import java.awt.*;

public class DisplayRecipeView extends JDialog {

    public DisplayRecipeView(JFrame frame, RecipeModel model) {

        // Create display recipe dialog
        super(frame, "Display Recipe", true);
        this.setSize(1000, 800);
        this.setLayout(new BorderLayout());

        // Add display recipe panel
        DisplayRecipePanel displayRecipePanel = new DisplayRecipePanel(model);
        this.add(displayRecipePanel, BorderLayout.CENTER);

        // Add 'Close' button
        CloseButton closeButton = new CloseButton(this);
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        closePanel.add(closeButton);
        this.add(closePanel, BorderLayout.SOUTH);

        // Make display recipe view visible
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}

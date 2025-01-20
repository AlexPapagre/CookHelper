package org.example;

import javax.swing.*;
import java.awt.*;

public class DisplayRecipePanel extends JPanel {

    public DisplayRecipePanel(DisplayRecipeModel model) {

        // Create display recipe text area
        JTextArea displayRecipeTextArea = new JTextArea(model.displayRecipe());
        displayRecipeTextArea.setEditable(false);
        displayRecipeTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane displayRecipeTextAreaScrollPane = new JScrollPane(displayRecipeTextArea);

        // Create display recipe panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(displayRecipeTextAreaScrollPane);
    }
}

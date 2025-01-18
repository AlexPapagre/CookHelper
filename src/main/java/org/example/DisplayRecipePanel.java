package org.example;

import javax.swing.*;

public class DisplayRecipePanel extends JPanel {

    public DisplayRecipePanel(RecipeModel model) {

        // Add display recipe text area
        DisplayRecipeTextArea displayRecipeTextArea = new DisplayRecipeTextArea(model);
        JScrollPane displayRecipeTextAreaScrollPane = new JScrollPane(displayRecipeTextArea);

        // Create display recipe panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(displayRecipeTextAreaScrollPane);
    }
}

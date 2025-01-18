package org.example;

import javax.swing.*;
import java.awt.*;

public class DisplayRecipeTextArea extends JTextArea {

    public DisplayRecipeTextArea(RecipeModel model) {

        // Create display recipe text area
        this.setEditable(false);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
        this.append("Συνταγή: '" + model.getName() + "' για " + model.getPeople() + " ");
        this.append((model.getPeople() == 1 ? "άτομο" : "άτομα") + "\n\n");
        this.append(model.displayRecipe());
    }
}

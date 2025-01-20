package org.example;

import javax.swing.*;
import java.awt.*;

public class MainMenuButtonPanel extends JPanel {

    public MainMenuButtonPanel(JFrame frame, DefaultListModel<String> listModel, JList<String> fileList) {

        // Add main menu button panel buttons
        DisplayRecipeButton displayRecipeButton = new DisplayRecipeButton(frame, fileList);
        ShoppingListButton shoppingListButton = new ShoppingListButton(frame, fileList);
        ExecuteRecipeButton executeRecipeButton = new ExecuteRecipeButton(frame, fileList);
        RemoveRecipesButton removeRecipesButton = new RemoveRecipesButton(frame, listModel, fileList);
        ExitButton exitButton = new ExitButton(frame);

        // Create main menu button panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalGlue());
        this.add(displayRecipeButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(shoppingListButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(executeRecipeButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(removeRecipesButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(exitButton);
        this.add(Box.createVerticalGlue());
    }
}

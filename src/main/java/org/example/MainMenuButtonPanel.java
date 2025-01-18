package org.example;

import javax.swing.*;
import java.awt.*;

public class MainMenuButtonPanel extends JPanel {

    public MainMenuButtonPanel(JFrame frame, JList<String> fileList) {

        // Create main menu button panel buttons
        DisplayRecipeButton displayRecipeButton = new DisplayRecipeButton(frame, fileList);
        ShoppingListButton shoppingListButton = new ShoppingListButton(frame, fileList);
        ExecuteRecipeButton executeRecipeButton = new ExecuteRecipeButton(frame, fileList);
        RemoveRecipeButton removeRecipeButton = new RemoveRecipeButton(frame, fileList);
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
        this.add(removeRecipeButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(exitButton);
        this.add(Box.createVerticalGlue());
    }
}

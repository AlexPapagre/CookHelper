package org.example;

import javax.swing.*;
import java.awt.*;

public class ShoppingListPanel extends JPanel {

    public ShoppingListPanel(ShoppingListModel model) {

        // Create shopping list text area
        JTextArea shoppingListTextArea = new JTextArea(model.shoppingList());
        shoppingListTextArea.setEditable(false);
        shoppingListTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane displayRecipeTextAreaScrollPane = new JScrollPane(shoppingListTextArea);

        // Create shopping list panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(displayRecipeTextAreaScrollPane);
    }
}

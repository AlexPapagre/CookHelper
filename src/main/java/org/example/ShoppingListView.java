package org.example;

import javax.swing.*;
import java.awt.*;

public class ShoppingListView extends JDialog {

    public ShoppingListView(JFrame frame, ShoppingListModel model) {

        // Create shopping list dialog
        super(frame, "Shopping List", true);
        this.setSize(1000, 800);
        this.setLayout(new BorderLayout());

        // Add shopping list panel
        ShoppingListPanel shoppingListPanel = new ShoppingListPanel(model);
        this.add(shoppingListPanel, BorderLayout.CENTER);

        // Add 'Close' button
        CloseButton closeButton = new CloseButton(this);
        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        closePanel.add(closeButton);
        this.add(closePanel, BorderLayout.SOUTH);

        // Make shopping list view visible
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}

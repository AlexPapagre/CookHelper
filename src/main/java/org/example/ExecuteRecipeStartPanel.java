package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeStartPanel extends JPanel {

    public ExecuteRecipeStartPanel(String text) {

        // Create display recipe text area
        JLabel executeRecipeLabel = new JLabel(text);
        executeRecipeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        executeRecipeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create display recipe panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(executeRecipeLabel);
    }
}

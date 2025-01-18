package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeStartPanel extends JPanel {

    public ExecuteRecipeStartPanel(String text) {

        // Create display recipe text area
        JTextArea executeRecipeTextArea = new JTextArea(text);
        executeRecipeTextArea.setEditable(false);
        executeRecipeTextArea.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create display recipe panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(executeRecipeTextArea);
    }
}

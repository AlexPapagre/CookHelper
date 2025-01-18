package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeButtonPanel extends JPanel {

    public ExecuteRecipeButtonPanel(JDialog dialog) {

        // Create execute recipe button panel
        super(new FlowLayout(FlowLayout.CENTER));

        // Add 'Start' button
        ExecuteRecipeStartButton executeRecipeStartButton = new ExecuteRecipeStartButton(dialog);
        this.add(executeRecipeStartButton);

        // Add 'Close' button
        CloseButton closeButton = new CloseButton(dialog);
        this.add(closeButton);
    }
}

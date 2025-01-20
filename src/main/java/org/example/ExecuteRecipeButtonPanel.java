package org.example;

import javax.swing.*;
import java.awt.*;

public class ExecuteRecipeButtonPanel extends JPanel {

    public ExecuteRecipeButtonPanel(JFrame frame, JDialog dialog, ExecuteRecipeModel model) {

        // Create execute recipe button panel
        super(new FlowLayout(FlowLayout.CENTER));

        // Add execute recipe button panel buttons
        ExecuteRecipeStartButton executeRecipeStartButton = new ExecuteRecipeStartButton(frame, dialog, model);
        CloseButton closeButton = new CloseButton(dialog);
        this.add(executeRecipeStartButton);
        this.add(closeButton);
    }
}

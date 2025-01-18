package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseButton extends JButton implements ActionListener {
    private final JDialog dialog;

    public CloseButton(JDialog dialog) {

        // Create 'Close' button
        super("Close");
        this.addActionListener(this);

        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
    }
}

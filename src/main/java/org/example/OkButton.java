package org.example;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class OkButton extends JButton implements ActionListener {

    public OkButton() {
        super("OK");
        this.addActionListener(this);
    }
}

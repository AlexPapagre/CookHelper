package org.example;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class PeopleOkButton extends JButton implements ActionListener {

    public PeopleOkButton() {
        super("OK");
        this.addActionListener(this);
    }
}

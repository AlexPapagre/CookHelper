package org.example;

import gr.hua.dit.oop2.countdown.Countdown;
import gr.hua.dit.oop2.countdown.Notifier;

import javax.swing.*;

public class NotifierImpl implements Notifier {
    private final java.util.Timer timer;
    private final JLabel label;

    public NotifierImpl(java.util.Timer timer, JLabel label) {
        this.timer = timer;
        this.label = label;
    }

    @Override
    public void finished(Countdown countdown) {
        countdown.stop();
        timer.cancel();
        timer.purge();
        label.setText("Τέλος χρόνου!");
    }
}

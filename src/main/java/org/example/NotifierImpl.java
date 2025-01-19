package org.example;

import gr.hua.dit.oop2.countdown.Countdown;
import gr.hua.dit.oop2.countdown.Notifier;

import javax.swing.*;
import java.util.Timer;

public class NotifierImpl implements Notifier {
    private final Timer timer;
    private final JLabel label;

    public NotifierImpl(Timer timer, JLabel label) {
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

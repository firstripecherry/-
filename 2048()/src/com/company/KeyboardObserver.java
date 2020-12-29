package com.company;

import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import javax.swing.JFrame;

public class KeyboardObserver extends Thread {
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue(100);
    private JFrame frame;

    public KeyboardObserver() {
    }

    public static Calendar access$000(KeyboardObserver this$0) {
        return null;
    }

    public void run() {
        this.frame = new JFrame("KeyPress Tester");
        this.frame.setTitle("Transparent JFrame Demo");
        this.frame.setDefaultCloseOperation(3);
        this.frame.setUndecorated(true);
        this.frame.setSize(400, 400);
        this.frame.setExtendedState(6);
        this.frame.setLayout(new GridBagLayout());
        this.frame.setOpacity(0.0F);
        this.frame.setVisible(true);
        this.frame.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }

            public void focusLost(FocusEvent e) {
                System.exit(0);
            }
        });
        this.frame.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                KeyboardObserver.this.keyEvents.add(e);
            }
        });
    }

    public boolean hasKeyEvents() {
        return !this.keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
        return (KeyEvent)this.keyEvents.poll();
    }
}

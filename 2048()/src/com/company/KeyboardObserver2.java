package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class KeyboardObserver$2 implements KeyListener {
    private final KeyboardObserver this$0;

    KeyboardObserver$2(KeyboardObserver this$0) {
        this.this$0 = this$0;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        KeyboardObserver. access$000(this.this$0).add(e);
    }
}


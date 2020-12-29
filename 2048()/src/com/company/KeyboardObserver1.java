package com.company;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class KeyboardObserver$1 implements FocusListener {
    private final KeyboardObserver this$0;

    KeyboardObserver$1(KeyboardObserver this$0) {
        this.this$0 = this$0;
    }

    public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        System.exit(0);
    }
}
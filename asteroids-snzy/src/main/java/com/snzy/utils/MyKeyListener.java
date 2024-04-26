package com.snzy.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MyKeyListener {

    KeyListener trueListener;

    Map<Integer, Consumer<Void>> keyEventBinding;

    public MyKeyListener() {
        this.keyEventBinding = new HashMap<>();
        this.trueListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
    }

    public void refreshKeyBinding() {
        this.trueListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                System.out.println("Input key " + key);
                Consumer<Void> f = keyEventBinding.get(key);
                if (f != null) {
                    f.accept(null);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
    }

    public enum KeyOp {
        Press, Release, Type
    }

    public void setMapping(char key, Consumer<Void> f) {
        setMapping(key, f, KeyOp.Press);
    }

    public void setMapping(char key, Consumer<Void> f, MyKeyListener.KeyOp keyOp) {
        int keyCode = KeyCode.getKeyCode(key);
        System.out.println("[setMapping] keyCode " + keyCode);
        this.keyEventBinding.put(keyCode, f);
        System.out.println(this.keyEventBinding.size());
        refreshKeyBinding();
    }

}

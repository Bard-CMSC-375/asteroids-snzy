package com.snzy.utils;

import java.util.function.Consumer;
import java.util.function.Function;

import com.snzy.graphics.WindowFrame;
import com.snzy.utils.MyKeyListener.KeyOp;

public class InputHandler {

    private MyKeyListener myKeyListener;

    public InputHandler() {
        myKeyListener = new MyKeyListener();
    }

    public void setKeyMapping(char key, Consumer<Void> f) {
        this.myKeyListener.setMapping(key, f, KeyOp.Press);
    }

    public void registerToMainFrame(WindowFrame mainFrame) {
        mainFrame.addKeyListener(this.myKeyListener.trueListener);
        System.out.println("listener added");
    }
}

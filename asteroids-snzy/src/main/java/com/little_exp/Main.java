package com.little_exp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
    public Main() {
        setTitle("Key Listener Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setFocusable(true);
        add(panel);

        panel.addKeyListener(new MyKeyListener());

        setVisible(true);
    }

    private static class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Key pressed: " + e.getKeyChar());
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

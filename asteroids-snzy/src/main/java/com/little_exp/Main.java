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
        panel.setFocusable(true); // 设置为可获取焦点，以便接收键盘事件
        add(panel);

        panel.addKeyListener(new MyKeyListener()); // 将键盘监听器添加到 JPanel 上

        setVisible(true);
    }

    private static class MyKeyListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Key pressed: " + e.getKeyChar());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // 按键释放时触发的操作
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // 键入字符时触发的操作
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

package com.little_exp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FirstDemo extends JFrame implements KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private int shipX = WIDTH / 2;
    private int shipY = HEIGHT / 2;
    private int shipAngle = 0; // 初始角度

    public FirstDemo() {
        setTitle("Asteroids Game Demo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // 清除之前的内容
        g2d.clearRect(0, 0, WIDTH, HEIGHT);

        // 画出飞船（三角形）
        int[] xPoints = {shipX, shipX - 20, shipX + 20};
        int[] yPoints = {shipY, shipY + 30, shipY + 30};
        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    // 按键事件处理
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:
                moveShipForward();
                break;
            case KeyEvent.VK_S:
                moveShipBackward();
                break;
            case KeyEvent.VK_A:
                rotateShipLeft();
                break;
            case KeyEvent.VK_D:
                rotateShipRight();
                break;
        }
        repaint();
    }

    // 按键释放事件处理
    @Override
    public void keyReleased(KeyEvent e) {
    }

    // 按键类型事件处理
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // 向前移动飞船
    private void moveShipForward() {
        shipX += (int) (10 * Math.sin(Math.toRadians(shipAngle))); // 根据角度计算 X 轴位移
        shipY -= (int) (10 * Math.cos(Math.toRadians(shipAngle))); // 根据角度计算 Y 轴位移
    }

    // 向后移动飞船
    private void moveShipBackward() {
        shipX -= (int) (10 * Math.sin(Math.toRadians(shipAngle))); // 根据角度计算 X 轴位移
        shipY += (int) (10 * Math.cos(Math.toRadians(shipAngle))); // 根据角度计算 Y 轴位移
    }

    // 左转飞船
    private void rotateShipLeft() {
        shipAngle -= 5; // 每次逆时针旋转 5 度
    }

    // 右转飞船
    private void rotateShipRight() {
        shipAngle += 5; // 每次顺时针旋转 5 度
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FirstDemo main = new FirstDemo();
            main.setVisible(true);
        });
    }
}

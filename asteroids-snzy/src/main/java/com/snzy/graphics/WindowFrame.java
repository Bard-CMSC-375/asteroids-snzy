package com.snzy.graphics;


import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame {

    // 1440 x 1024
    // 1280 x 800

    public JLayeredPane layeredPane;
    public WindowFrame() {
        this.setTitle("ASTEROIDS - SNZY");
        Dimension size = new Dimension(GraphicConfig.FRAME_WIDTH, GraphicConfig.FRAME_HEIGHT);

        this.setSize(size);
        this.setMaximumSize(size);
        this.setMaximumSize(size);
        this.setPreferredSize(size);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setFocusable(true);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(GraphicConfig.FRAME_WIDTH, GraphicConfig.FRAME_HEIGHT));
        setContentPane(layeredPane);
    }

    public void addPainter(Component component, int layer) {
        layeredPane.add(component, layer);
    }

}
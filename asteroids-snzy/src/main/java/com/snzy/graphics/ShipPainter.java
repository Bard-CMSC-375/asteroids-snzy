package com.snzy.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.snzy.entities.Ship;

public class ShipPainter extends JPanel {

    Ship ship;

    public ShipPainter(Ship ship) {
        // size must be the whole canvas to draw a ship anywhere
        Dimension size = new Dimension(GraphicConfig.FRAME_WIDTH, GraphicConfig.FRAME_HEIGHT);
        this.setSize(size);
        setVisible(true);
        this.ship = ship;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Clear previous content
        g2d.clearRect(0, 0, getWidth(), getHeight());

        // Calculate the coordinates of the triangle vertices
        int[] xPoints = { ship.shipX, ship.shipX - 10, ship.shipX + 10 };
        int[] yPoints = { ship.shipY, ship.shipY + 20, ship.shipY + 20 };

        // Rotate the coordinate system to the direction of the ship
        g2d.rotate(Math.toRadians(ship.shipAngle), ship.shipX, ship.shipY);

        // Draw the ship (triangle)
        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Draw the arrow
        int[] arrowX = { ship.shipX, ship.shipX - 5, ship.shipX + 5 };
        int[] arrowY = { ship.shipY - 20, ship.shipY - 10, ship.shipY - 10 };
        g2d.fillPolygon(arrowX, arrowY, 3);

        // Reset the coordinate system
        g2d.rotate(-Math.toRadians(ship.shipAngle), ship.shipX, ship.shipY);
        repaint();
    }
}

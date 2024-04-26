package com.snzy.entities;

public class Ship {
    public int shipX = 100;
    public int shipY = 100;

    public int shipAngle = 0;

    public void moveShipForward() {
        System.out.println("moving forward");
        shipX += (int) (10 * Math.sin(Math.toRadians(shipAngle)));
        shipY -= (int) (10 * Math.cos(Math.toRadians(shipAngle)));
    }

    public void moveShipBackward() {
        shipX -= (int) (10 * Math.sin(Math.toRadians(shipAngle)));
        shipY += (int) (10 * Math.cos(Math.toRadians(shipAngle)));
    }

    public void rotateShipLeft() {
        shipAngle -= 5;
    }

    public void rotateShipRight() {
        shipAngle += 5;
    }
}

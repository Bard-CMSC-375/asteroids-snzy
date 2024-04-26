package com.snzy.core;

import com.snzy.entities.Ship;
import com.snzy.graphics.ShipPainter;
import com.snzy.graphics.WindowFrame;
import com.snzy.utils.InputHandler;

public class GameManager {

    InputHandler inputHandler;
    Ship ship;

    WindowFrame mainFrame;

    public GameManager(WindowFrame mainFrame) {
        inputHandler = new InputHandler();

        ship = new Ship();
        mainFrame.addPainter(new ShipPainter(ship), 1);


        defaultKeyMapping();
        // CAUTION: MUST register after key mapping is set
        inputHandler.registerToMainFrame(mainFrame);
    }

    public void defaultKeyMapping() {
        this.inputHandler.setKeyMapping('w', (Void) -> ship.moveShipForward());
        this.inputHandler.setKeyMapping('s', (Void) -> ship.moveShipBackward());
        this.inputHandler.setKeyMapping('a', (Void) -> ship.rotateShipLeft());
        this.inputHandler.setKeyMapping('d', (Void) -> ship.rotateShipRight());
    }
}

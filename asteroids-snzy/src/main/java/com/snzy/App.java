package com.snzy;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import com.snzy.core.GameManager;
import com.snzy.graphics.ShipPainter;
import com.snzy.graphics.WindowFrame;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // ArrayList<AbstractCreature> p_list = new ArrayList<>();
        // TestPlayer1 p1 = new TestPlayer1("test_player_1");
        // TestPlayer2 p2 = new TestPlayer2("test_player_2");
        // p_list.add(p1);
        // p_list.add(p2);

        SwingUtilities.invokeLater(() -> {
            WindowFrame frame = new WindowFrame();
            new GameManager(frame);
        });
    
        // GUI gui = new GUI(frame);
    }

}

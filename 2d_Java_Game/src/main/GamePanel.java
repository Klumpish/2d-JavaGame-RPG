package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //    screen settings
    final int originalTileSize = 16; //16x16 tile the amount of pixels for
    // the spirits
    final int scale = 3;

    final int titleSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16; // horizontally
    final int maxScreenRow = 12; // vertically
    final int screenWidth = titleSize * maxScreenCol;  // 768px
    final int screenHeight = titleSize * maxScreenRow; // 576px

    //    constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
//        if set to true all drawing from this component will be done in an
//        offscreen painting buffer, it improves game's rending performance
        this.setDoubleBuffered(true);
    }
}

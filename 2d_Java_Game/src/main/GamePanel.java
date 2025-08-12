package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //    screen settings
    final int originalTileSize = 16; //16x16 tile the amount of pixels for
    // the spirits
    final int scale = 3;

    final int titleSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16; // horizontally
    final int maxScreenRow = 12; // vertically
    final int screenWidth = titleSize * maxScreenCol;  // 768px
    final int screenHeight = titleSize * maxScreenRow; //

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set Player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    //    constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        //if set to true all drawing from this component will be done in an
        //offscreen painting buffer, it improves game's rending performance
        this.setDoubleBuffered(true);
        //adds our keyHandler to our game
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        //init our thread
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //game loop
        while (gameThread != null) {
            //1. update: update info such as Char positions
            update();
            //2. Draw: draw the screen with the updated info
            repaint();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, titleSize, titleSize);

        //we use dispose so that after its done it wont take up system resources
        g2.dispose();
    }
}

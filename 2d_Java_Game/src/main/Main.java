package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

//        create a window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2d Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //Pack causes this window to be sized to fit the preferred size and
        // layout of its subcomponents (GamePanel)
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }

}

package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_up_2.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_down_2.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_left_2.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream(
              "/Player/Walking_sprites/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true ||
          keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
            }
            if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            }
            if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
            }
            if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction) {
            case "up":

                image = (spriteNum == 1) ? up1 : up2;
                break;
            case "down":
                image = (spriteNum == 1) ? down1 : down2;
                break;
            case "left":
                image = (spriteNum == 1) ? left1 : left2;
                break;
            case "right":
                image = (spriteNum == 1) ? right1 : right2;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}

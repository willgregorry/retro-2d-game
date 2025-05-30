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

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(14, 15, 19, 22);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 93;
        worldY = gp.tileSize * 75;
        speed = 3;
        direction = "idle";
    }

    public void getPlayerImage() {
        try {
            idle1 = ImageIO.read(getClass().getResourceAsStream("/player/player_idle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/player_idle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/player_idle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/player_idle4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/player/player_idle5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/player/player_idle6.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/player_up3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/player_up4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/player_up5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/player_up6.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/player_down3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/player_down4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/player_down5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/player_down6.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/player_left3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/player_left4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/player_left5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/player_left6.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/player_right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/player_right4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/player_right5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/player_right6.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed) {
                direction = "up";
            }
            else if (keyH.downPressed) {
                direction = "down";
            }
            else if (keyH.leftPressed) {
                direction = "left";
            }
            else if (keyH.rightPressed) {
                direction = "right";
            }

            // Check collision
            collisionOn = false;
            gp.collisionDetector.checkTile(this);

            if (!collisionOn) {
                switch (direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 5) {
                spriteNumber++;
                if (spriteNumber > 6) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        } else {
            direction = "idle";
            spriteCounter++;
            if (spriteCounter > 5) {
                spriteNumber++;
                if (spriteNumber > 6) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "idle":
                if (spriteNumber == 1) {
                    image = idle1;
                }
                if (spriteNumber == 2) {
                    image = idle2;
                }
                if (spriteNumber == 3) {
                    image = idle3;
                }
                if (spriteNumber == 4) {
                    image = idle4;
                }
                if (spriteNumber == 5) {
                    image = idle5;
                }
                if (spriteNumber == 6) {
                    image = idle6;
                }
                break;
            case "up":
                if (spriteNumber == 1) {
                    image = up1;
                }
                if (spriteNumber == 2) {
                    image = up2;
                }
                if (spriteNumber == 3) {
                    image = up3;
                }
                if (spriteNumber == 4) {
                    image = up4;
                }
                if (spriteNumber == 5) {
                    image = up5;
                }
                if (spriteNumber == 6) {
                    image = up6;
                }
                break;
            case "down":
                if (spriteNumber == 1) {
                    image = down1;
                }
                if (spriteNumber == 2) {
                    image = down2;
                }
                if (spriteNumber == 3) {
                    image = down3;
                }
                if (spriteNumber == 4) {
                    image = down4;
                }
                if (spriteNumber == 5) {
                    image = down5;
                }
                if (spriteNumber == 6) {
                    image = down6;
                }
                break;
            case "left":
                if (spriteNumber == 1) {
                    image = left1;
                }
                if (spriteNumber == 2) {
                    image = left2;
                }
                if (spriteNumber == 3) {
                    image = left3;
                }
                if (spriteNumber == 4) {
                    image = left4;
                }
                if (spriteNumber == 5) {
                    image = left5;
                }
                if (spriteNumber == 6) {
                    image = left6;
                }
                break;
            case "right":
                if (spriteNumber == 1) {
                    image = right1;
                }
                if (spriteNumber == 2) {
                    image = right2;
                }
                if (spriteNumber == 3) {
                    image = right3;
                }
                if (spriteNumber == 4) {
                    image = right4;
                }
                if (spriteNumber == 5) {
                    image = right5;
                }
                if (spriteNumber == 6) {
                    image = right6;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

}

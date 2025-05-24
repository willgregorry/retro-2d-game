package main;

import java.awt.*;

public class UI {

    GamePanel gp;
    Font arial40;

    public UI(GamePanel gp) {
        this.gp = gp;
         arial40 = new Font("Arial", Font.PLAIN, 40);
    }

//    public void draw(Graphics2D g2) {
//        g2.setFont(arial40);
//        g2.setColor(Color.WHITE);
//        g2.drawString("Score: " + gp.player.score, 40, 50);
//    }

}

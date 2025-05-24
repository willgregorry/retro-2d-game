package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    static Image icon = new ImageIcon("res/icons/favicon.png").getImage();
    public static void main(String[] args) {
        JFrame window = new JFrame("Retro 2D Game");

        GamePanel gp = new GamePanel();
        gp.playSfx(1);
        Pages.showSplash(5500);

        Pages.showLoading(3000);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setIconImage(icon);
        window.setResizable(false);
        window.setUndecorated(true);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);

        gamePanel.setUpGame();
        gamePanel.startGameThread();

        window.setVisible(true);


    }
}

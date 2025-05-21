package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LoadingPage extends JWindow {

    public LoadingPage(String message) {
        setSize(768, 576);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("Tahoma", Font.BOLD, 16));
                g.setColor(Color.WHITE);
                g.drawString(message, 650, 520);
            }
        };

        panel.setBackground(Color.BLACK);
        add(panel);
    }

    public static void showLoading(String message, int durationMs) {
        LoadingPage screen = new LoadingPage(message);
        screen.setVisible(true);

        try {
            Thread.sleep(durationMs);  // Blocks main thread (not recommended for production)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        screen.setVisible(false);
        screen.dispose();
    }

    public static void showSplash(int durationMs) {
        JWindow splash = new JWindow();

        BufferedImage logoImage = null;
        try {
            logoImage = ImageIO.read(LoadingPage.class.getResourceAsStream("/intros/Multimedia4.png"));
        } catch (Exception e) {
            System.err.println("Failed to load splash image: " + e.getMessage());
        }

        BufferedImage finalLogoImage = logoImage;
        JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (finalLogoImage != null) {
                    int x = (getWidth() - finalLogoImage.getWidth()) / 2;
                    int y = (getHeight() - finalLogoImage.getHeight()) / 2;
                    g.drawImage(finalLogoImage, x, y, this);
                }
            }
        };

        content.setPreferredSize(new Dimension(768, 576));
        splash.add(content);
        splash.pack();
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        try {
            Thread.sleep(durationMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splash.setVisible(false);
        splash.dispose();
    }
}

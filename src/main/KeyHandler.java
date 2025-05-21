package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean idling = false;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = true;
            idling = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
            idling = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed= true;
            idling = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            idling = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
            idling = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
            idling = true;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed= false;
            idling = true;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
            idling = true;
        }

    }
}

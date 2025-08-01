package com.clay.ge.io;

import java.awt.event.*;
import java.util.HashSet;

public class GameEvent implements KeyListener, MouseListener, MouseMotionListener {
    private final HashSet<Integer> keysPressed = new HashSet<>();
    private boolean mousePressed = false;
    private boolean mouseClicked = false;
    private int mousex = 0, mousey = 0;

    // KeyListener

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keysPressed.add(keyEvent.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keysPressed.remove(keyEvent.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    // MouseListener

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        mousePressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseClicked = true;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {}

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mousex = mouseEvent.getX();
        mousey = mouseEvent.getY();
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        mousex = mouseEvent.getX();
        mousey = mouseEvent.getY();
    }

    // Utility untuk semak
    public boolean isKeyPressed(GameKeys keys) {
        int keyCode = keys.keyCode();
        return keysPressed.contains(keyCode);
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public boolean isMouseClicked() {
        boolean clicked = mouseClicked;
        mouseClicked = false; // reset after read
        return clicked;
    }

    public int getMouseX() {
        return mousex;
    }

    public int getMouseY() {
        return mousey;
    }
    
}

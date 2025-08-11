package com.clay.ge.io;

import java.awt.event.*;
import java.util.HashSet;

public class GameEvent implements KeyListener, MouseListener, MouseMotionListener {
    private final HashSet<Integer> keysPressed = new HashSet<>();
    private boolean mouseButtonLeftPressed = false;
    private boolean mouseButtonMiddlePressed = false;
    private boolean mouseButtonRightPressed = false;
    private boolean mouseButtonLeftClicked = false;
    private boolean mouseButtonMiddleClicked = false;
    private boolean mouseButtonRightClicked = false;
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
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) mouseButtonLeftPressed = true;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON2) mouseButtonMiddlePressed = true;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON3) mouseButtonRightPressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) mouseButtonLeftPressed = false;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON2) mouseButtonMiddlePressed = false;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON3) mouseButtonRightPressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) mouseButtonLeftClicked = true;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON2) mouseButtonMiddleClicked = true;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON3) mouseButtonRightClicked = true;
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

    public String getKeyText() {
        if (keysPressed.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int keyCode : keysPressed) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(KeyEvent.getKeyText(keyCode));
        }
        return sb.toString();
    }

    /*
    public boolean isMouseButtonLeftPressed() {
        return mouseButtonLeftPressed;
    }

    public boolean isMouseButtonMiddlePressed() {
        return mouseButtonMiddlePressed;
    }

    public boolean isMouseButtonRightPressed() {
        return mouseButtonRightPressed;
    }
    */

    public boolean isMouseButtonPressed(GameMouse mouse) {
        if (mouse == GameMouse.BUTTON_LEFT) {
            return mouseButtonLeftPressed;
        } else if (mouse == GameMouse.BUTTON_MIDDLE) {
            return mouseButtonMiddlePressed;
        } else if (mouse == GameMouse.BUTTON_RIGHT) {
            return mouseButtonRightPressed;
        } else return false;
    }

    /*
    public boolean isMouseButtonLeftClicked() {
        boolean clicked = mouseButtonLeftClicked;
        mouseButtonLeftClicked = false; // reset after read
        return clicked;
    }

    public boolean isMouseButtonMiddleClicked() {
        boolean clicked = mouseButtonMiddleClicked;
        mouseButtonMiddleClicked = false; // reset after read
        return clicked;
    }

    public boolean isMouseButtonRightClicked() {
        boolean clicked = mouseButtonRightClicked;
        mouseButtonRightClicked = false; // reset after read
        return clicked;
    }
    */
    public boolean isMouseButtonClicked(GameMouse mouse) {
        boolean clicked = false;
        if (mouse == GameMouse.BUTTON_LEFT) {
            clicked = mouseButtonLeftClicked;
            mouseButtonLeftClicked = false; // reset after read
        } else if (mouse == GameMouse.BUTTON_MIDDLE) {
            clicked = mouseButtonMiddleClicked;
            mouseButtonMiddleClicked = false; // reset after read
        } else if (mouse == GameMouse.BUTTON_RIGHT) {
            clicked = mouseButtonRightClicked;
            mouseButtonRightClicked = false; // reset after read
        }
        return clicked;
    }
    
    public int getMouseX() {
        return mousex;
    }

    public int getMouseY() {
        return mousey;
    }

}

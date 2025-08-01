package com.clay.ge.ui;

import com.clay.ge.render.GameColor;

public class GameWindow {
    private String title = "Untitled";
    private int x = 0;
    private int y = 0;
    private int width = 800;
    private int height = 600;
    private boolean resizable = false;
    private boolean visible = true;
    private GameColor bgColor = GameColor.BLACK;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

    public boolean isResizable() {
        return this.resizable;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setBackgroundColor(GameColor color) {
        this.bgColor = color;
    }

    public GameColor getBackgroundColor() {
        return bgColor;
    }

}

package com.clay.ge.render;

import java.awt.*;

public class GameRender {
    private Graphics graphics;

    public void setGraphics(Graphics g) {
        this.graphics = g;
    }

    public Graphics2D getGraphics() {
        return (Graphics2D) graphics;
    }

}

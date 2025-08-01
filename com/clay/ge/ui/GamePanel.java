package com.clay.ge.ui;

import com.clay.ge.render.GameColor;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GamePanel {
    private Canvas canvas = new Canvas();

    public GamePanel(int width, int height, GameColor bgColor) {
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setSize(width, height);
        canvas.setBackground(bgColor.toAWTColor());
    }

    public Canvas canvas() {
        return this.canvas;
    }

    public void createBufferStrategy(int buffer) {
        canvas.createBufferStrategy(buffer);
    }

    public BufferStrategy bufferStrategy() {
        return canvas.getBufferStrategy();
    }

}

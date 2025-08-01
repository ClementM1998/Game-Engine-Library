package com.clay.ge.shape;

import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;

import java.awt.*;

public class GamePoint extends GameShape {
    private float x, y;
    private float size = 2;

    public GamePoint() {}

    public GamePoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return this.x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return this.y;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getSize() {
        return this.size;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        g2.fillOval((int) x, (int) y, (int) (size), (int) (size));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

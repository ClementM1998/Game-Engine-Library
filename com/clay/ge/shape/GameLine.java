package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;

import java.awt.*;

public class GameLine extends GameShape {
    private float x1, y1;
    private float x2, y2;

    public GameLine() {}

    public GameLine(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void set(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getX1() {
        return x1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getY1() {
        return y1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public float getX2() {
        return x2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public float getY2() {
        return y2;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        g2.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x1, (int) y1, (int) x2, (int) y2);
    }

}

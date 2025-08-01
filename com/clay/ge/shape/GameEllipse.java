package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;
import com.clay.ge.render.GameShapeType;

import java.awt.*;

public class GameEllipse extends GameShape {
    private float x, y, width, height;

    public GameEllipse() {}

    public GameEllipse(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void set(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWidth() {
        return width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        if (getType().equals(GameShapeType.Fill)) g2.fillOval((int) x, (int) y, (int) width, (int) height);
        else g2.drawOval((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

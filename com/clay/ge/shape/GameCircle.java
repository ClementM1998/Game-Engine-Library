package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;
import com.clay.ge.render.GameShapeType;

import java.awt.*;

public class GameCircle extends GameShape {
    private float x, y, radius;

    public GameCircle() {}

    public GameCircle(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius - 1;
    }

    public void set(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius - 1;
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

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        if (getType().equals(GameShapeType.Fill)) g2.fillOval((int) x, (int) y, (int) radius, (int) radius);
        else g2.drawOval((int) x, (int) y, (int) radius, (int) radius);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) radius, (int) radius);
    }

}

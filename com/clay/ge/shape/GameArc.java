package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;
import com.clay.ge.render.GameShapeType;

import java.awt.*;

public class GameArc extends GameShape {
    private float x, y, width, height, startAngle, sweepAngle;

    public GameArc() {}

    public GameArc(float x, float y, float width, float height, float startAngle, float sweepAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
    }

    public void set(float x, float y, float width, float height, float startAngle, float sweepAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.sweepAngle = sweepAngle;
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

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    public float getStartAngle() {
        return startAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        if (getType().equals(GameShapeType.Fill)) g2.fillArc((int) x, (int) y, (int) width, (int) height, (int) startAngle, (int) sweepAngle);
        else g2.drawArc((int) x, (int) y, (int) width, (int) height, (int) startAngle, (int) sweepAngle);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

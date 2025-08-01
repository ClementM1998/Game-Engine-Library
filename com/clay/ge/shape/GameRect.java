package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;
import com.clay.ge.render.GameShapeType;

import java.awt.*;

public class GameRect extends GameShape {
    private float left, top, right, bottom;

    public GameRect() {}

    public GameRect(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right - 1;
        this.bottom = bottom - 1;
    }

    public void set(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right - 1;
        this.bottom = bottom - 1;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getLeft() {
        return left;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public float getTop() {
        return top;
    }

    public void setRight(float right) {
        this.right = right - 1;
    }

    public float getRight() {
        return right;
    }

    public void setBottom(float bottom) {
        this.bottom = bottom - 1;
    }

    public float getBottom() {
        return bottom;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        if (getType().equals(GameShapeType.Fill)) g2.fillRect((int) left, (int) top, (int) right, (int) bottom);
        else g2.drawRect((int) left, (int) top, (int) right, (int) bottom);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) left, (int) top, (int) right, (int) bottom);
    }

}

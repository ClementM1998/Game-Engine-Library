package com.clay.ge.shape;

import com.clay.ge.render.*;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class GameRectangle extends GameShape {
    private float left, top, right, bottom;

    public GameRectangle() {}

    public GameRectangle(GameColor color) {
        setColor(color);
    }

    public GameRectangle(float left, float top, float right, float bottom) {
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

        AffineTransform old = g2.getTransform();
        g2.rotate(getRotate(), left + right / 2, top + bottom / 2);

        if (getType().equals(GameShapeType.Fill)) {
            g2.fillRect((int) left, (int) top, (int) right, (int) bottom);
            g2.setStroke(strokeFill());
            g2.setColor(getStrokeColor().toAWTColor());
            g2.drawRect((int) left, (int) top, (int) right, (int) bottom);
        } else {
            g2.setStroke(strokeDraw());
            g2.drawRect((int) left, (int) top, (int) right, (int) bottom);
        }

        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(
                0.1f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                5.f,
                new float[] {2.5f, 2.5f},
                0.f
        ));

        int xx = (int) (left - getStroke() / 2) - 2;
        int yy = (int) (top - getStroke() / 2) - 2;
        int xw = (int) (right + getStroke()) + 4;
        int yh = (int) (bottom + getStroke()) + 4;

        //setBounds(new Rectangle(xx, yy, xw, yh));

        Point a = new Point(xx, yy);
        Point b = new Point(xx + xw, yy);
        Point c = new Point(xx + xw, yy + yh);
        Point d = new Point(xx, yy + yh);

        GameBounds bounds = new GameBounds();

        bounds.add(a);
        bounds.add(b);
        bounds.add(c);
        bounds.add(d);

        setBounds(bounds);

        if (getBorderLine()) {
            g2.drawLine(a.x, a.y, b.x, b.y);
            g2.drawLine(b.x, b.y, c.x, c.y);
            g2.drawLine(c.x, c.y, d.x, d.y);
            g2.drawLine(d.x, d.y, a.x, a.y);
        }

        g2.setTransform(old);

    }

}

package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameColor;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;

import java.awt.*;

public class GamePoint extends GameShape {
    private float x, y;
    private float size = 2;

    public GamePoint() {}

    public GamePoint(GameColor color) {
        setColor(color);
    }

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
        g2.setStroke(strokeDraw());
        g2.fillOval((int) x, (int) y, (int) (size), (int) (size));

        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(
                0.1f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                5.f,
                new float[] {2.5f, 2.5f},
                0.f
        ));

        int xx = (int) (x - getStroke() / 2) - 2;
        int yy = (int) (y - getStroke() / 2) - 2;
        int xw = (int) (size + getStroke()) + 4;
        int yh = (int) (size + getStroke()) + 4;

        int r = (int) size / 3;
        Point a = new Point(xx + r, yy);
        Point b = new Point(xx + xw - r, yy);
        Point c = new Point(xx + xw, yy + r);
        Point d = new Point(xx + xw, yy + yh - r);
        Point e = new Point(xx + xw - r, yy + yh);
        Point f = new Point(xx + r, yy + yh);
        Point g = new Point(xx, yy + yh - r);
        Point h = new Point(xx, yy + r);

        GameBounds bounds = new GameBounds();

        bounds.add(a);
        bounds.add(b);
        bounds.add(c);
        bounds.add(d);
        bounds.add(e);
        bounds.add(f);
        bounds.add(g);
        bounds.add(h);

        setBounds(bounds);

        if (getBorderLine()) {
            g2.drawLine(a.x, a.y, b.x, b.y);
            g2.drawLine(b.x, b.y, c.x, c.y);
            g2.drawLine(c.x, c.y, d.x, d.y);
            g2.drawLine(d.x, d.y, e.x, e.y);
            g2.drawLine(e.x, e.y, f.x, f.y);
            g2.drawLine(f.x, f.y, g.x, g.y);
            g2.drawLine(g.x, g.y, h.x, h.y);
            g2.drawLine(h.x, h.y, a.x, a.y);
        }

    }

}

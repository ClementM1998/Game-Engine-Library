package com.clay.ge.shape;

import com.clay.ge.render.*;

import java.awt.*;

public class GameCircle extends GameShape {
    private float x, y, radius;

    public GameCircle() {}

    public GameCircle(GameColor color) {
        setColor(color);
    }

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
        if (getType().equals(GameShapeType.Fill)) {
            g2.fillOval((int) x, (int) y, (int) radius, (int) radius);
            g2.setStroke(strokeFill());
            g2.setColor(getStrokeColor().toAWTColor());
            g2.drawOval((int) x, (int) y, (int) radius, (int) radius);
        } else {
            g2.setStroke(strokeDraw());
            g2.drawOval((int) x, (int) y, (int) radius, (int) radius);
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

        int xx = (int) (x - getStroke() / 2) - 2;
        int yy = (int) (y - getStroke() / 2) - 2;
        int xw = (int) (radius + getStroke()) + 4;
        int yh = (int) (radius + getStroke()) + 4;

        //setBounds(new Rectangle(xx, yy, xw, yh));

        int r = (int) radius / 3;
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

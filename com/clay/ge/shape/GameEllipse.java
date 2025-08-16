package com.clay.ge.shape;

import com.clay.ge.render.*;

import java.awt.*;

public class GameEllipse extends GameShape {
    private float x, y, width, height;

    public GameEllipse() {}

    public GameEllipse(GameColor color) {
        setColor(color);
    }

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

        //AffineTransform old = g2.getTransform();
        //g2.rotate(getRotate(), x + width / 2, y + height / 2);

        if (getType().equals(GameShapeType.Fill)) {
            g2.fillOval((int) x, (int) y, (int) width, (int) height);
            g2.setStroke(strokeFill());
            g2.setColor(getStrokeColor().toAWTColor());
            g2.drawOval((int) x, (int) y, (int) width, (int) height);
        } else {
            g2.setStroke(strokeDraw());
            g2.drawOval((int) x, (int) y, (int) width, (int) height);
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
        int xw = (int) (width + getStroke()) + 4;
        int yh = (int) (height + getStroke()) + 4;

        //setBounds(new Rectangle(xx, yy, xw, yh));

        int rx = (int) width / 3;
        int ry = (int) height / 3;

        Point a = new Point(xx + rx, yy);
        Point b = new Point(xx + xw - rx, yy);
        Point c = new Point(xx + xw, yy + ry);
        Point d = new Point(xx + xw, yy + yh - ry);
        Point e = new Point(xx + xw - rx, yy + yh);
        Point f = new Point(xx + rx, yy + yh);
        Point g = new Point(xx, yy + yh - ry);
        Point h = new Point(xx, yy + ry);

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

        //g2.setTransform(old);

    }

}

package com.clay.ge.shape;

import com.clay.ge.render.*;

import java.awt.*;

public class GameArc extends GameShape {
    private float x, y, width, height, startAngle, sweepAngle;

    public GameArc() {}

    public GameArc(GameColor color) {
        setColor(color);
    }

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
        if (getType().equals(GameShapeType.Fill)) {
            g2.fillArc((int) x, (int) y, (int) width, (int) height, (int) startAngle, (int) sweepAngle);
            g2.setStroke(strokeFill());
            g2.setColor(getStrokeColor().toAWTColor());
            g2.drawArc((int) x, (int) y, (int) width, (int) height, (int) startAngle, (int) sweepAngle);
        } else {
            g2.setStroke(strokeDraw());
            g2.drawArc((int) x, (int) y, (int) width, (int) height, (int) startAngle, (int) sweepAngle);
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

    }

}

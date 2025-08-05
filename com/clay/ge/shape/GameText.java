package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameColor;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class GameText extends GameShape {
    private float x, y;
    private String text;
    private float size = 12;
    private GameFont font = null;

    public GameText() {
        setAntialias(true);
    }

    public GameText(GameColor color) {
        setColor(color);
    }

    public GameText(String text, float x, float y) {
        this.text = text;
        this.x = x;
        this.y = y;
        setAntialias(true);
    }

    public void set(String text, float x, float y) {
        this.text = text;
        this.x = x;
        this.y = y;
        setAntialias(true);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getSize() {
        return this.size;
    }

    public void setFont(GameFont font) {
        this.font = font;
    }

    public GameFont getFont() {
        return this.font;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());

        if (font == null) g2.setColor(getColor().toAWTColor());
        else g2.setColor(font.getColor().toAWTColor());

        if (font == null) g2.setFont(new Font("Arial", Font.PLAIN, (int) size));
        else g2.setFont(font.toAWTFont());

        FontMetrics fm = g2.getFontMetrics();
        int ascent = fm.getAscent();
        g2.setStroke(strokeDraw());
        g2.drawString(text, (int) x, (int) ascent + y);

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
        int xw = (int) (fm.stringWidth(text) + getStroke()) + 4;
        int yh = (int) (fm.getAscent() + getStroke()) + 4;

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

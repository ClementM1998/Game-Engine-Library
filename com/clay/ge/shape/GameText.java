package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;

import java.awt.*;

public class GameText extends GameShape {
    private float x, y;
    private String text;
    private float size = 12;
    private GameFont font = null;

    public GameText() {
        setAntialias(true);
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

    public String getText() {
        return this.text;
    }

    public float getX() {
        return this.x;
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
        g2.setStroke(stroke());
        g2.drawString(text, (int) x, (int) ascent + y);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

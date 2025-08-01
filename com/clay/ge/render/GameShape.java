package com.clay.ge.render;

import java.awt.*;

public abstract class GameShape {
    private boolean antialias = false;
    private GameColor color = GameColor.WHITE;
    private boolean visible = true;
    private GameShapeType type = GameShapeType.Draw;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    private float stroke = 1.0f;
    private GameBounds bounds = new GameBounds();

    public void setAntialias(boolean antialias) {
        this.antialias = antialias;
    }

    public boolean isAntialias() {
        return this.antialias;
    }

    public void setColor(GameColor color) {
        this.color = color;
    }

    public GameColor getColor() {
        return this.color;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setType(GameShapeType type) {
        this.type = type;
    }

    public GameShapeType getType() {
        return this.type;
    }

    public RenderingHints getRenderingHints() {
        if (antialias) {
            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        } else {
            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        }
        return hints;
    }

    public void setStroke(float stroke) {
        this.stroke = stroke;
    }

    public float getStroke() {
        return this.stroke;
    }

    public BasicStroke stroke() {
        return new BasicStroke(stroke);
    }

    public abstract void draw(GameRender render);
    public abstract Rectangle getBounds();

}

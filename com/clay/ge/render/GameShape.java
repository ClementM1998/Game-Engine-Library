package com.clay.ge.render;

import java.awt.*;

public abstract class GameShape {
    private boolean antialias = true;
    private GameColor color = GameColor.WHITE;
    private GameColor strokeColor = GameColor.WHITE;
    private boolean visible = true;
    private GameShapeType type = GameShapeType.Draw;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    private float strokeFill = 0.6f;
    private float strokeDraw = 1f;
    private boolean border = false;
    private GameBounds bounds = new GameBounds();
    private float rotation = 0;
    private boolean isRotate = false;

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
        this.strokeDraw = stroke;
        this.strokeFill = stroke;
    }

    public float getStroke() {
        return Math.max(strokeDraw, strokeFill);
    }

    public void setStrokeColor(GameColor strokeColor) {
        this.strokeColor = strokeColor;
    }

    public GameColor getStrokeColor() {
        return strokeColor;
    }

    public BasicStroke strokeFill() {
        return new BasicStroke(strokeFill);
    }

    public BasicStroke strokeDraw() {
        return new BasicStroke(strokeDraw);
    }

    public void setBorderLine(boolean border) {
        this.border = border;
    }

    public boolean getBorderLine() {
        return this.border;
    }

    public void setBounds(GameBounds bounds) {
        this.bounds = bounds;
    }

    public GameBounds getBounds() {
        return bounds;
    }

    public void setRotate(float rotation) {
        this.rotation = rotation;
        this.isRotate = true;
    }

    public float getRotate() {
        return rotation;
    }

    public boolean isRotate() {
        return isRotate;
    }

    public abstract void draw(GameRender render);

}

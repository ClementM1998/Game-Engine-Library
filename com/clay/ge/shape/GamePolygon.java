package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;
import com.clay.ge.render.GameShapeType;

import java.awt.*;

public class GamePolygon extends GameShape {
    private float[] xPoints, yPoints;
    private int size;

    public GamePolygon() {}

    public GamePolygon(float[] xPoints, float[] yPoints, int size) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.size = size;
    }

    public void set(float[] xPoints, float[] yPoints, int size) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
        this.size = size;
    }

    public float[] getXPoints() {
        return xPoints;
    }

    public float[] getYPoints() {
        return yPoints;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;
        if (xPoints.length != size) return;
        if (yPoints.length != size) return;

        int[] xpoint = new int[size];
        int[] ypoint = new int[size];

        for (int i = 0;i < size;i++) xpoint[i] = (int) xPoints[i];
        for (int i = 0;i < size;i++) ypoint[i] = (int) yPoints[i];

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        if (getType().equals(GameShapeType.Fill)) g2.fillPolygon(xpoint, ypoint, size);
        else g2.drawPolygon(xpoint, ypoint, size);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

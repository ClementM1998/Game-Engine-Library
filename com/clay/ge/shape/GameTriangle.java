package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;
import com.clay.ge.render.GameShapeType;

import java.awt.*;

public class GameTriangle extends GameShape {
    private float xPoints[], yPoints[];

    public GameTriangle() {}

    public GameTriangle(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.xPoints = new float[] {x1, x2, x3};
        this.yPoints = new float[] {y1, y2, y3};
    }

    public GameTriangle(float xPoints[], float yPoints[]) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public void set(float x1, float y1, float x2, float y2, float x3, float y3) {
        this.xPoints = new float[] {x1, x2, x3};
        this.yPoints = new float[] {y1, y2, y3};
    }

    public void set(float xPoints[], float yPoints[]) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public float[] getXPoints() {
        return this.xPoints;
    }

    public float[] getYPoints() {
        return this.yPoints;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;
        if (xPoints.length != yPoints.length) return;

        int[] xp = new int[] { (int) xPoints[0], (int) xPoints[1], (int) xPoints[2] };
        int[] yp = new int[] { (int) yPoints[0], (int) yPoints[1], (int) yPoints[2] };

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        g2.setStroke(stroke());
        if (getType().equals(GameShapeType.Fill)) g2.fillPolygon(xp, yp, 3);
        else g2.drawPolygon(xp, yp, 3);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

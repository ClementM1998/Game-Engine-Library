package com.clay.ge.shape;

import com.clay.ge.render.*;

import java.awt.*;
import java.util.ArrayList;

public class GameTriangle extends GameShape {
    private float xPoints[], yPoints[];

    public GameTriangle() {}

    public GameTriangle(GameColor color) {
        setColor(color);
    }

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

        int[] xpoint = new int[] { (int) xPoints[0], (int) xPoints[1], (int) xPoints[2] };
        int[] ypoint = new int[] { (int) yPoints[0], (int) yPoints[1], (int) yPoints[2] };

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        g2.setColor(getColor().toAWTColor());
        if (getType().equals(GameShapeType.Fill)) {
            g2.fillPolygon(xpoint, ypoint, 3);
            g2.setStroke(strokeFill());
            g2.setColor(getStrokeColor().toAWTColor());
            g2.drawPolygon(xpoint, ypoint, 3);
        } else {
            g2.setStroke(strokeDraw());
            g2.drawPolygon(xpoint, ypoint, 3);
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

        int minX = xpoint[0], maxX = xpoint[0];
        int minY = xpoint[0], maxY = ypoint[0];

        for (int i = 1;i < 3;i++) {
            if (xpoint[i] < minX) minX = xpoint[i];
            if (xpoint[i] > maxX) maxX = xpoint[i];
            if (ypoint[i] < minY) minY = ypoint[i];
            if (ypoint[i] > maxY) maxY = ypoint[i];
        }

        int xx = (int) (minX - getStroke() / 2) - 2;
        int yy = (int) (minY - getStroke() / 2) - 2;
        int xw = (int) (maxX - minX + getStroke()) + 4;
        int yh = (int) (maxY - minY + getStroke()) + 4;

        //setBounds(new Rectangle(xx, yy, xw, yh));

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0;i < 3;i++) {
            points.add(new Point(xpoint[i], ypoint[i]));
        }

        GameBounds bounds = new GameBounds(points);
        setBounds(bounds);

        if (getBorderLine()) {
            for (int i = 0;i < 3;i++) {
                Point a = points.get(i);
                Point b = points.get((i + 1) % points.size());
                g2.drawLine(a.x, a.y, b.x, b.y);
            }
        }

    }

}

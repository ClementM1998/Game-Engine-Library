package com.clay.ge.shape;

import com.clay.ge.render.*;

import java.awt.*;
import java.util.ArrayList;

public class GamePolygon extends GameShape {
    private float[] xPoints, yPoints;
    private int size;

    public GamePolygon() {}

    public GamePolygon(GameColor color) {
        setColor(color);
    }

    public GamePolygon(float[] xPoints, float[] yPoints, int size) {
        set(xPoints, yPoints, size);
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
        if (getType().equals(GameShapeType.Fill)) {
            g2.fillPolygon(xpoint, ypoint, size);
            g2.setStroke(strokeFill());
            g2.setColor(getStrokeColor().toAWTColor());
            g2.drawPolygon(xpoint, ypoint, size);
        } else {
            g2.setStroke(strokeDraw());
            g2.drawPolygon(xpoint, ypoint, size);
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

        for (int i = 0;i < size;i++) {
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
        for (int i = 0;i < size;i++) {
            points.add(new Point(xpoint[i], ypoint[i]));
        }

        GameBounds bounds = new GameBounds(points);
        setBounds(bounds);

        if (getBorderLine()) {
            for (int i = 0;i < points.size();i++) {
                Point a = points.get(i);
                Point b = points.get((i + 1) % points.size());
                g2.drawLine(a.x, a.y, b.x, b.y);
            }
        }

    }

}

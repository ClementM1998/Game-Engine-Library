package com.clay.ge.render;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class GameBounds {
    private ArrayList<Point> points = new ArrayList<>();
    private Point collision;

    public GameBounds() {}

    public GameBounds(ArrayList<Point> points) {
        this.points = points;
    }

    public GameBounds(Point p) {
        points.add(p);
    }

    public void add(Point p) {
        points.add(p);
    }

    public int size() {
        return points.size();
    }

    public Point get(int index) {
        // akan di kemas kini jika index lebih kecil atau index lebih besar dari size()
        if (index < 0) index = 0;
        if (index >= points.size()) index = points.size() - 1;
        return points.get(index);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    // Dapatkan senarai garis dari titik-titik
    public ArrayList<Line2D> getEdges() {
        ArrayList<Line2D> edges = new ArrayList<>();
        int size = points.size();
        for (int i = 0;i < size;i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % size);
            edges.add(new Line2D.Float(p1, p2));
        }
        return edges;
    }

    public boolean intersects(GameBounds bounds) {
        ArrayList<Line2D> edges1 = getEdges();
        ArrayList<Line2D> edges2 = bounds.getEdges();

        for (Line2D e1 : edges1) {
            for (Line2D e2 : edges2) {
                if (e1.intersectsLine(e2)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Semak jika satu titik berdalam polygon (gunakan ray-casting)
    public boolean contains(Point p) {
        int crossings = 0;
        int size = points.size();
        for (int i = 0;i < size;i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % size);
            if (((p1.y > p.y) != (p2.y > p.y)) && (p.x < (double) (p2.x - p1.x) * (p.y - p1.y) / (double) (p2.y - p1.y) + p1.x)) {
                crossings++;
            }
        }
        return (crossings % 2 == 1);
    }

}

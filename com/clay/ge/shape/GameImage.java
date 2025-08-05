package com.clay.ge.shape;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameImage extends GameShape {
    private BufferedImage image;
    private int x, y;
    private int width, height;
    private boolean loaded = false;

    public GameImage() {}

    public GameImage(File file, int x, int y) {
        try {
            image = ImageIO.read(file);
            this.x = x;
            this.y = y;
            width = image.getWidth();
            height = image.getHeight();
            loaded = true;
        } catch (IOException e) {
            image = null;
            loaded = false;
        }
    }

    public GameImage(File file, int x, int y, int width, int height) {
        try {
            image = ImageIO.read(file);
            this.x = x;
            this.y = y;
            this.width = Math.max(image.getWidth(), width);
            this.height = Math.max(image.getHeight(), height);
            loaded = true;
        } catch (IOException e) {
            image = null;
            loaded = false;
        }
    }

    public void set(File file, int x, int y) {
        try {
            image = ImageIO.read(file);
            this.x = x;
            this.y = y;
            width = image.getWidth();
            height = image.getHeight();
            loaded = true;
        } catch (IOException e) {
            image = null;
            loaded = false;
        }
    }

    public void set(File file, int x, int y, int width, int height) {
        try {
            image = ImageIO.read(file);
            this.x = x;
            this.y = y;
            this.width = Math.max(image.getWidth(), width);
            this.height = Math.max(image.getHeight(), height);
            loaded = true;
        } catch (IOException e) {
            image = null;
            loaded = false;
        }
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void draw(GameRender render) {
        if (!isVisible()) return;
        if (render == null) return;

        Graphics2D g2 = render.getGraphics();
        g2.setRenderingHints(getRenderingHints());
        if (loaded && image != null) {
            g2.drawImage(image, x, y, width, height, null);
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

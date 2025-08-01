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
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

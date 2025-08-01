package com.clay.ge.render;

import java.awt.*;

public class GameColor {
    // Warna Asas
    public static final GameColor BLACK = new GameColor(0, 0, 0);
    public static final GameColor WHITE = new GameColor(255, 255, 255);
    public static final GameColor RED = new GameColor(255, 0, 0);
    public static final GameColor GREEN = new GameColor(0, 255, 0);
    public static final GameColor BLUE = new GameColor(0, 0, 255);
    public static final GameColor YELLOW = new GameColor(255, 255, 0);
    public static final GameColor CYAN = new GameColor(0, 255, 255);
    public static final GameColor MAGENTA = new GameColor(255, 0, 255);
    public static final GameColor TRANSPARENT = new GameColor(0, 0, 0, 0);

    // Warna tersuai (lebih gelap, lebih cerah)
    public static final GameColor DARK_GRAY = new GameColor(192, 192, 192);
    public static final GameColor LIGHT_GRAY = new GameColor(64, 64, 64);
    public static final GameColor BROWN = new GameColor(139, 69, 19);
    public static final GameColor GOLD = new GameColor(255, 215, 0);
    public static final GameColor SKY = new GameColor(135, 206, 235);
    public static final GameColor PURPLE = new GameColor(128, 0, 128);

    private int alpha;
    private int red;
    private int green;
    private int blue;

    public GameColor(int alpha, int red, int green, int blue) {
        this.alpha = clamp(alpha);
        this.red = clamp(red);
        this.green = clamp(green);
        this.blue = clamp(blue);
    }

    public GameColor(int red, int green, int blue) {
        this(255, red, green, blue);
    }

    public GameColor(float alphaF, float redF, float greenF, float blueF) {
        this.alpha = clamp((int) (alphaF * 255));
        this.red = clamp((int) (redF * 255));
        this.green = clamp((int) (greenF * 255));
        this.blue = clamp((int) (blueF * 255));
    }

    public GameColor(float redF, float greenF, float blueF) {
        this(255, redF, greenF, blueF);
    }

    public GameColor(int hex) {
        if ((hex & 0xFF000000) != 0) {
            // Ada alpha (format: AARRGGBB)
            this.alpha = (hex >> 24) & 0xFF;
            this.red = (hex >> 16) & 0xFF;
            this.green = (hex >> 8) & 0xFF;
            this.blue = hex & 0xFF;
        } else {
            // Tiada alpha (format: RRGGBB)
            this.alpha = 255;
            this.red = (hex >> 16) & 0xFF;
            this.green = (hex >> 8) & 0xFF;
            this.blue = hex & 0xFF;
        }
    }

    public GameColor(String hexStr) {
        if (hexStr == null || !hexStr.startsWith("#")) throw new IllegalArgumentException("Format hex mesti bermula dengan '#'");
        String hex = hexStr.substring(1); // buang '#'
        long value = Long.parseLong(hex, 16);
        if (hex.length() == 6) {
            // #RRGGBB
            this.alpha = 255;
            this.red = (int) ((value >> 16) & 0xFF);
            this.green = (int) ((value >> 8) & 0xFF);
            this.blue = (int) ((value & 0xFF));
        } else if (hex.length() == 8) {
            // #AARRGGBB
            this.alpha = (int) ((value >> 24) & 0xFF);
            this.red = (int) ((value >> 16) & 0xFF);
            this.green = (int) ((value >> 8) & 0xFF);
            this.blue = (int) ((value & 0xFF));
        } else throw new IllegalArgumentException("Hex mesti 6 atau 8 digit selepas '#'");
    }

    private int clamp(int value) {
        return Math.max(0, Math.min(255, value));
    }

    public int toARGB() {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    public int toRGB() {
        return (red << 16) | (green << 8) | blue;
    }

    public String toHexARGB() {
        return String.format("#%02X%02X%02X%02X", alpha, red, green, blue);
    }

    public String toHexRGB() {
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    public static GameColor fromHex(String hex) {
        return new GameColor(hex);
    }

    public static GameColor random() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        return new GameColor(red, green, blue);
    }

    public GameColor copy() {
        return new GameColor(alpha, red, green, blue);
    }

    public Color toAWTColor() {
        return new Color(red, green, blue, alpha);
    }

}

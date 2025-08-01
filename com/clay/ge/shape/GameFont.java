package com.clay.ge.shape;

import com.clay.ge.render.GameColor;

import java.awt.*;

public class GameFont {
    private String name;
    private int size;
    private int style; // Font.PLAIN, Font.BOLD, Font.ITALIC
    private GameColor color;

    public static final int Plain = Font.PLAIN;
    public static final int Bold = Font.BOLD;
    public static final int Italic = Font.ITALIC;

    public GameFont(String name, int size, int style, GameColor color) {
        this.name = name;
        this.size = size;
        this.style = style;
        this.color = color;
    }

    // Default Font
    public GameFont() {
        this("Arial", 16, Plain, GameColor.WHITE);
    }

    public Font toAWTFont() {
        return new Font(name, style, size);
    }

    public Color toAWTColor() {
        return color.toAWTColor();
    }

    public void setName(String name) {
        if (name == null || name.equals("")) name = "Arial";
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getStyle() {
        return this.style;
    }

    public void setColor(GameColor color) {
        this.color = color;
    }

    public GameColor getColor() {
        return this.color;
    }

}

package com.clay.ge.util;

public class GameMath {
    public static final float PI = 3.1415927f;
    public static final float DEG2RAD = PI / 180f;
    public static final float RAD2DEG = 180f / PI;

    // Tukar darjah ke radian
    public static float toRadians(float degress) {
        return degress * DEG2RAD;
    }

    // Tukar radian ke darjah
    public static float toDegrees(float radians) {
        return radians * RAD2DEG;
    }

    // Clamp nilai antara min dan max
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    // Linear interpolation
    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    // Jarak antara dua titik (2D)
    public static float distance(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    // Sudut antara dua titik (radian)
    public static float angleBetween(float x1, float y1, float x2, float y2) {
        return (float) Math.atan2(y2 - y1, x2 - x1);
    }

    // Random float antara min dan max
    public static float randomFloat(float min, float max) {
        return min + (float) Math.random() * (max - min);
    }

    // Bulatan ke integer terdekat
    public static int round(float value) {
        return Math.round(value);
    }

    /* // Testing GameMath
    public static void main(String[] args) {
        float angle = GameMath.toRadians(90);
        System.out.println("90 degrees in radians: " + angle);

        float d = GameMath.distance(0, 0, 3, 4);
        System.out.println("Distance: " + d);
    }
     */

}

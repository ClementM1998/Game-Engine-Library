package com.clay.ge.util;

import com.clay.ge.render.GameBounds;
import com.clay.ge.render.GameShape;

public class GameCollision {

    public static boolean collision(GameShape shape1, GameShape shape2) {
        if (shape1 == null) return false;
        if (shape2 == null) return false;
        //System.out.println("In process collision");

        if (shape1.getBounds() == null) return false;
        if (shape2.getBounds() == null) return false;

        GameBounds bounds1 = shape1.getBounds();
        GameBounds bounds2 = shape2.getBounds();

        if (bounds1.intersects(bounds2)) return true;
        if (bounds2.intersects(bounds1)) return true;

        //System.out.println("End process collision");
        return false;
    }

}

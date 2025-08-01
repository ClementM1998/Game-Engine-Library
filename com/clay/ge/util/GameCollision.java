package com.clay.ge.util;

import com.clay.ge.render.GameShape;

public class GameCollision {

    public static boolean collision(GameShape shape1, GameShape shape2) {
        if (shape1 == null) return false;
        if (shape2 == null) return false;
        //System.out.println("In process collision");
        if (shape1.getBounds().intersects(shape2.getBounds())) return true;
        //System.out.println("End process collision");
        return false;
    }

}

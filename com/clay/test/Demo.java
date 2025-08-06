package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.render.GameColor;
import com.clay.ge.shape.GameCircle;
import com.clay.ge.shape.GameRectangle;
import com.clay.ge.shape.GameText;
import com.clay.ge.shape.GameTriangle;
import com.clay.ge.ui.GameWindow;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameRender;
import com.clay.ge.util.GameCollision;

public class Demo extends GameApplication {
    private GameCircle circle = new GameCircle();
    private GameCircle circle1 = new GameCircle();
    private GameRectangle rect = new GameRectangle();
    private GameText text = new GameText();
    private GameTriangle triangle = new GameTriangle();
    private float cx = 200, cy = 200, radius = 50;
    private float width, height;
    private boolean collision = false;
    private float[] xpoint = {300, 325, 350}, ypoint = {150, 100, 150};

    @Override
    public void init(GameWindow window) {
        CreateWindow("Demo", true);
        width = GetWindowWidth() - radius;
        height = GetWindowHeight() - radius;

        text.set("0x0", 0, 0);

        circle.set(cx, cy, radius);
        circle.setAntialias(true);
        //circle.setType(GameShapeType.Fill);
        //circle.setStroke(3.5f);

        circle1.set(300, 300, 100);


        rect.set(100, 200, 50, 50);
        rect.setColor(GameColor.BLUE);
        //rect.setType(GameShapeType.Fill);

        triangle.set(xpoint, ypoint);
        triangle.setColor(GameColor.BLUE);
    }

    @Override
    public void update(GameEvent event) {
        if (IsKeyPressed(GameKeys.GK_LEFT)) cx -= 5;
        if (IsKeyPressed(GameKeys.GK_UP)) cy -= 5;
        if (IsKeyPressed(GameKeys.GK_RIGHT)) cx += 5;
        if (IsKeyPressed(GameKeys.GK_DOWN)) cy += 5;
        if (IsKeyPressed(GameKeys.GK_ESCAPE)) CloseWindow();
        if (IsMouseButtonLeftPressed()) System.out.println("Mouse Button Left : " + IsMouseButtonLeftPressed());
        if (IsMouseButtonMiddlePressed()) CloseWindow();
        if (IsMouseButtonRightPressed()) System.out.println("Mouse Button Right : " + IsMouseButtonRightPressed());

        if (cx > 0 && cy > 0 && cx < width && cy < height) {
            collision = false;
        } else {
            if (cx <= 0) {
                cx = 0;
                collision = true;
            }
            if (cy <= 0) {
                cy = 0;
                collision = true;
            }
            if (cx >= width) {
                cx = width;
                collision = true;
            }
            if (cy >= height) {
                cy = height;
                collision = true;
            }
        }


        if (collision) circle.setColor(GameColor.BROWN);
        else circle.setColor(GameColor.WHITE);

        if (GameCollision.collision(circle, rect)) {
            circle.setColor(GameColor.BLUE);
            rect.setColor(GameColor.BLUE);
        } else {
            rect.setColor(GameColor.GREEN);
        }

        if (GameCollision.collision(circle, triangle)) {
            triangle.setColor(GameColor.BLUE);
        } else {
            triangle.setColor(GameColor.GREEN);
        }

        if (GameCollision.collision(circle, circle1)) {
            circle1.setColor(GameColor.WHITE);
        } else {
            circle1.setColor(GameColor.BROWN);
        }

        text.setText("Move : " + (int) cx + "x" + (int) cy);

        circle.setX(cx);
        circle.setY(cy);
        //rect.setLeft(cx);
        //rect.setTop(cy);
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();

        text.draw(render);
        circle.draw(render);
        rect.draw(render);
        triangle.draw(render);
        circle1.draw(render);
    }

    public static void main(String[] args) {
        launch(new Demo());
    }

}

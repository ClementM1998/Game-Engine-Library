package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameColor;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShapeType;
import com.clay.ge.shape.GameCircle;
import com.clay.ge.shape.GameRectangle;
import com.clay.ge.shape.GameText;
import com.clay.ge.ui.GameWindow;

import java.util.ArrayList;

public class DemoObject extends GameApplication {
    private float mx, my;
    private float vert = 0, hori = 0;
    private float boxL = 50, boxT = 50, boxR, boxB;
    private GameRectangle rectangle = new GameRectangle(new GameColor(80 , GameColor.BLUE));
    private GameCircle circle = new GameCircle(new GameColor(80, GameColor.GREEN));
    private GameText textKey = new GameText(GameColor.WHITE);
    private GameText textMouse = new GameText(GameColor.WHITE);
    private GameText textMove = new GameText(GameColor.WHITE);

    @Override
    public void init(GameWindow window) {
        CreateWindow("Demo Object");

        boxR = GetWindowWidth() - 90;
        boxB = GetWindowHeight() - 90;

        rectangle.set(boxL, boxT, boxR, boxB);
        rectangle.setType(GameShapeType.Fill);
        rectangle.setStrokeColor(GameColor.BLUE);

        circle.set(boxL + vert, boxT + hori, 50);
        circle.setType(GameShapeType.Fill);
        circle.setStrokeColor(GameColor.GREEN);

        textKey.set("key: $", 0, 0);
        textMouse.set("mouse: 0 , 0", 0, 15);
        textMove.set("move: 0 , 0", 0, 15 * 2);

    }

    @Override
    public void update(GameEvent event) {
        mx = GetMouseX();
        my = GetMouseY();

        if (IsKeyPressed(GameKeys.GK_Q)) CloseWindow();

        if (IsKeyPressed(GameKeys.GK_LEFT)) vert -= 6;
        if (IsKeyPressed(GameKeys.GK_RIGHT)) vert += 6;
        if (IsKeyPressed(GameKeys.GK_UP)) hori -= 6;
        if (IsKeyPressed(GameKeys.GK_DOWN)) hori += 6;

        if (boxL > (boxL + vert + 50) || boxT > (boxT + hori + 50) || (boxR + 50) < (boxL + vert + 50) || (boxB + 50) < (boxT + hori + 50)) {
            circle.setColor(GameColor.RED);
            rectangle.setColor(GameColor.RED);
        } else {
            circle.setColor(GameColor.GREEN);
            rectangle.setColor(GameColor.BLUE);
        }

        circle.setX(boxL + vert);
        circle.setY(boxT + hori);

        textKey.setText("key: " + GetKeyText());
        textMouse.setText("mouse: " + GetMouseX() + " , " + GetMouseY());
        textMove.setText("move: " + (100 + vert) + " , " + (100 + hori));

    }

    @Override
    public void render(GameRender render) {
        ClearWindow();

        rectangle.draw(render);
        circle.draw(render);

        textKey.draw(render);
        textMouse.draw(render);
        textMove.draw(render);

    }

    public static void main(String[] args) {
        launch(new DemoObject());
    }
}

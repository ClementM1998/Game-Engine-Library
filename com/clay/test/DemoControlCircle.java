package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.audio.GameAudio;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameColor;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShapeType;
import com.clay.ge.shape.GameCircle;
import com.clay.ge.shape.GameEllipse;
import com.clay.ge.shape.GameLine;
import com.clay.ge.ui.GameWindow;

public class DemoControlCircle extends GameApplication {
    private int width, height;
    private float ax = 50, ay = 50; // Posisi auto
    private float adx = 2, ady = 3; // Kelajuan auto
    private float mx = 50, my = 50; // Posisi move
    private float mdx = 3; // Kelajuan move
    private float px = 0, py = 0; // Posisi player
    private float gravity = 0.5f;
    private int diameter = 60;
    private float shadowPlayerDiameter = 0;

    private GameCircle ballAuto = new GameCircle(GameColor.RED);
    private GameCircle ballMove = new GameCircle(GameColor.GREEN);
    private GameCircle ballPlayer = new GameCircle(GameColor.BLUE);

    private GameEllipse shadowAuto = new GameEllipse(GameColor.BLACK);
    private GameEllipse shadowMove = new GameEllipse(GameColor.BLACK);
    private GameEllipse shadowPlayer = new GameEllipse(GameColor.BLACK);

    private GameLine ground = new GameLine(GameColor.BLACK );
    private boolean jump = false;

    @Override
    public void init(GameWindow window) {
        CreateWindow("Demo Control Circle");
        SetBackgroundWindow(new GameColor(240, 240, 240));
        SetFullscreenMode();

        ShowTitleFPS();

        width = GetWindowWidth() - diameter;
        height = GetWindowHeight() - diameter * 2;

        px = 150;
        py = height;

        my = height;

        ballPlayer.set(px, py, diameter);
        ballPlayer.setType(GameShapeType.Fill);
        ballPlayer.setStrokeColor(GameColor.BLACK);
        shadowPlayer.set(px , height + diameter, diameter, 10);
        shadowPlayer.setType(GameShapeType.Fill);
        shadowPlayer.setStrokeColor(GameColor.BLACK);

        ballAuto.set(ax, ay, diameter);
        ballAuto.setType(GameShapeType.Fill);
        ballAuto.setStrokeColor(GameColor.BLACK);
        shadowAuto.set(ax, height + diameter, diameter, 10);
        shadowAuto.setType(GameShapeType.Fill);
        shadowAuto.setStrokeColor(GameColor.BLACK);

        ballMove.set(mx, my, diameter);
        ballMove.setType(GameShapeType.Fill);
        ballMove.setStrokeColor(GameColor.BLACK);
        shadowMove.set(mx, height + diameter, diameter, 10);
        shadowMove.setType(GameShapeType.Fill);
        shadowMove.setStrokeColor(GameColor.BLACK);

        ground.set(0, height + diameter, width + diameter, height + diameter);
    }

    @Override
    public void update(GameEvent event) {
        if (IsKeyPressed(GameKeys.GK_ESCAPE)) CloseWindow();

        // Untuk Ball Player

        if (IsKeyPressed(GameKeys.GK_LEFT)) px -= 5;
        else if (IsKeyPressed(GameKeys.GK_RIGHT)) px += 5;

        if (IsKeyPressed(GameKeys.GK_SPACE) && !jump) {
            py = -20;
            jump = true;
        }

        py += gravity;
        shadowPlayerDiameter += gravity;

        float nextY = ballPlayer.getY() + py;

        if (px > width) px = width;
        if (px < 0) px = 0;

        if (jump) {
            shadowPlayerDiameter += gravity;
            shadowPlayer.setX(px + (shadowPlayerDiameter));
            shadowPlayer.setWidth(diameter - (shadowPlayerDiameter * 2));
        } else {
            shadowPlayer.setX(px);
            shadowPlayer.setWidth(diameter);
        }

        if (nextY >= height) {
            nextY = height;
            py = 0;
            shadowPlayerDiameter = 0;
            jump = false;
        }

        ballPlayer.setX(px);
        ballPlayer.setY(nextY);

        // Untuk Ball Auto

        if (ax < 0 || ax > width) adx = -adx;
        if (ay < 0 || ay > height) ady = -ady;

        ax += adx;
        ay += ady;

        ballAuto.setX(ax);
        ballAuto.setY(ay);
        shadowAuto.setX(ax);

        // Untuk Ball Move

        if (mx < 0 || mx > width) mdx = -mdx;

        mx += mdx;

        ballMove.setX(mx);
        shadowMove.setX(mx);
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();

        ballAuto.draw(render);
        ballMove.draw(render);
        ballPlayer.draw(render);

        ground.draw(render);

        shadowAuto.draw(render);
        shadowMove.draw(render);
        shadowPlayer.draw(render);

    }

    public static void main(String[] args) {
        launch(new DemoControlCircle());
    }

}

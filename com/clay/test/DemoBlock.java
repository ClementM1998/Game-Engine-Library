package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameRender;
import com.clay.ge.shape.GameCircle;
import com.clay.ge.shape.GamePoint;
import com.clay.ge.shape.GameRectangle;
import com.clay.ge.ui.GameWindow;

public class DemoBlock extends GameApplication {
    int x = 100, y = 60, width, height;
    int mx = 0, my = 0, radius = 50;
    int left, top, right, bottom;

    GamePoint point = new GamePoint();

    GameRectangle background = new GameRectangle();
    GameCircle player = new GameCircle();

    @Override
    public void init(GameWindow window) {
        CreateWindow("Demo Block", true);
        ShowTitleFPS();

        width = GetWindowWidth() - radius;
        height = GetWindowHeight() - radius;

        radius = (width / 3 - height / 3) / 4;
        if (radius < y) radius = y;

        left = x;
        top = y;
        right = (width - left);
        bottom = (height - top);
        background.set(left, top, right - x + radius, bottom - y + radius);

        player.set(mx, my, radius);

        int px = width / 2;
        int py = height / 2;
        point.set(px, py);
    }

    @Override
    public void update(GameEvent event) {

        if (IsKeyPressed(GameKeys.GK_ESCAPE)) CloseWindow();

        if (IsKeyPressed(GameKeys.GK_LEFT)) mx -= 6;
        if (IsKeyPressed(GameKeys.GK_RIGHT)) mx += 6;

        if (IsKeyPressed(GameKeys.GK_UP)) my -= 6;
        if (IsKeyPressed(GameKeys.GK_DOWN)) my += 6;

        if (mx < left) mx = left;
        if (mx > right) mx = right;
        if (my < top) my = top;
        if (my > bottom) my = bottom;

        player.setX(mx);
        player.setY(my);
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();
        background.draw(render);

        player.draw(render);

        point.draw(render);
    }

    public static void main(String[] args) {
        launch(new DemoBlock());
    }

}

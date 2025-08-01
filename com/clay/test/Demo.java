package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.render.GameColor;
import com.clay.ge.render.GameShapeType;
import com.clay.ge.ui.GameWindow;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameRender;
import com.clay.ge.shape.*;

public class Demo extends GameApplication {
    private GameCircle circle = new GameCircle();
    private GameRect rect = new GameRect();
    private GameRect box = new GameRect();
    private GameTriangle triangle = new GameTriangle();
    private GamePolygon polygon = new GamePolygon();
    private GamePoint point = new GamePoint();
    private float x = 0, y = 0;
    private float width, height;
    private float radius = 50;

    @Override
    public void init(GameWindow window) {
        CreateWindow("Demo", true);
        SetBackgroundWindow(GameColor.RED);

        width = window.getWidth();
        height = window.getHeight();

        circle.set(x, y, radius);
        circle.setColor(GameColor.BROWN);
        circle.setType(GameShapeType.Fill);

        rect.set(0, 0, width, height);

        box.set(0, 0, radius, radius);

        triangle.set(new float[] {
                0, 25, 50
        }, new float[] {
                50, 0, 50
        });

        float[] xpoints = {100, 150, 200, 180, 120};
        float[] ypoints = {100, 80, 100, 150, 150};
        int npoints = xpoints.length;

        polygon.set(xpoints, ypoints, npoints);
        polygon.setAntialias(true);

        point.set(300, 300);

    }

    @Override
    public void update(GameEvent event) {
        if (IsKeyPressed(GameKeys.GK_LEFT)) x-=8.5f;
        if (IsKeyPressed(GameKeys.GK_UP)) y-=8.5f;
        if (IsKeyPressed(GameKeys.GK_RIGHT)) x+=8.5f;
        if (IsKeyPressed(GameKeys.GK_DOWN)) y+=8.5f;
        if (IsKeyPressed(GameKeys.GK_ESCAPE)) CloseWindow();

        circle.setX(x);
        circle.setY(y);
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();

        circle.draw(render);
        rect.draw(render);
        box.draw(render);
        triangle.draw(render);
        polygon.draw(render);
        point.draw(render);
    }

    public static void main(String[] args) {
        launch(new Demo());
    }

}

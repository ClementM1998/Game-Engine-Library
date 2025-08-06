package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameColor;
import com.clay.ge.render.GameRender;
import com.clay.ge.render.GameShapeType;
import com.clay.ge.shape.*;
import com.clay.ge.ui.GameWindow;
import com.clay.ge.util.GameCollision;

public class DemoShape extends GameApplication {

    private GameEllipse ellipse = new GameEllipse();
    private GameLine line = new GameLine();
    private GamePolygon polygon = new GamePolygon();
    private GameRectangle rectangle = new GameRectangle();
    private GameCircle circle = new GameCircle();
    private GameText text = new GameText();
    private GamePoint point = new GamePoint();

    private float x = 100;
    private float y = 400;

    private float rotate = 0;

    @Override
    public void init(GameWindow window) {
        ShowTitleFPS();

        ellipse.set(x, y, 180, 80);
        ellipse.setBorderLine(true);
        ellipse.setColor(GameColor.DARK_GRAY);
        ellipse.setType(GameShapeType.Fill);

        line.set(100, 100, 200, 200);

        polygon.set(new float[] {
                300, 350, 400, 450, 500, 400, 300
        }, new float[] {
                150, 100, 120, 100, 150, 250, 150
        }, 7);
        polygon.setBorderLine(true);
        polygon.setColor(GameColor.RED);
        polygon.setType(GameShapeType.Fill);

        rectangle.set(300, 300, 100, 200);
        rectangle.setBorderLine(true);
        rectangle.setColor(GameColor.BLUE);
        rectangle.setType(GameShapeType.Fill);

        circle.set(50, 50, 80);
        circle.setBorderLine(true);
        circle.setColor(new GameColor(200, 255, 255, 255));
        circle.setType(GameShapeType.Fill);

        text.set("Hello World!", 500, 100);
        text.setBorderLine(true);

        point.set(600, 300);
        point.setBorderLine(true);

    }

    @Override
    public void update(GameEvent event) {
        if (IsKeyPressed(GameKeys.GK_ESCAPE)) CloseWindow();
        if (IsKeyPressed(GameKeys.GK_LEFT)) ellipse.setX(x -= 5);
        if (IsKeyPressed(GameKeys.GK_RIGHT)) ellipse.setX(x += 5);
        if (IsKeyPressed(GameKeys.GK_UP)) ellipse.setY(y -= 5);
        if (IsKeyPressed(GameKeys.GK_DOWN)) ellipse.setY(y += 5);
        if (IsKeyPressed(GameKeys.GK_SPACE)) rectangle.setRotate(rotate += 5);
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();
        line.draw(render);
        polygon.draw(render);

        ellipse.draw(render);

        rectangle.draw(render);
        circle.draw(render);
        text.draw(render);
        point.draw(render);

        if (GameCollision.collision(circle, ellipse)) {
            text.setText("Collision circle and ellipse");
        } else if (GameCollision.collision(polygon, ellipse)) {
            text.setText("Collision polygon and ellipse");
        } else if (GameCollision.collision(rectangle, ellipse)) {
            text.setText("Collision rectangle and ellipse");
        } else if (GameCollision.collision(line, ellipse)) {
            text.setText("Collision line and ellipse");
        } else if (GameCollision.collision(point, ellipse)) {
            text.setText("Collision point and ellipse");
        } else text.setText("Hello World");

    }

    public static void main(String[] args) {
        launch(new DemoShape());
    }

}

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
        radius = 
}

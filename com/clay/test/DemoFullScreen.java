package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameRender;
import com.clay.ge.shape.GameText;
import com.clay.ge.ui.GameWindow;

public class DemoFullScreen extends GameApplication {
    private GameText text = new GameText();

    @Override
    public void init(GameWindow window) {
        SetFullscreenMode();

        text.setSize(18);
        text.set("Press 'Esc' to close window", GetWindowWidth() / 2 - (text.getSize() * 2), GetWindowHeight() / 2);
    }

    @Override
    public void update(GameEvent event) {
        if (IsKeyPressed(GameKeys.GK_ESCAPE)) CloseWindow();
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();

        text.draw(render);
    }

    public static void main(String[] args) {
        launch(new DemoFullScreen());
    }

}

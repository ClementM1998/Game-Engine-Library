package com.clay.test;

import com.clay.ge.GameApplication;
import com.clay.ge.shape.GameText;
import com.clay.ge.ui.GameWindow;
import com.clay.ge.io.GameEvent;
import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameRender;

import java.util.ArrayList;

public class Demo extends GameApplication {
    private ArrayList<GameText> arrayText = new ArrayList<>();

    @Override
    public void init(GameWindow window) {
        CreateWindow("Demo");

        arrayText.add(new GameText("Welcome to Game Engine Library", 10, 10));
        arrayText.add(new GameText("  > Press 'Esc' to exit", 10, 30));

        for (GameText text : arrayText) {
            text.setSize(15);
        }
    }

    @Override
    public void update(GameEvent event) {
        if (IsKeyPressed(GameKeys.GK_ESCAPE)) CloseWindow();
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();

        if (arrayText != null) {
            for (GameText text : arrayText) text.draw(render);
        }
    }

    public static void main(String[] args) {
        launch(new Demo());
    }

}

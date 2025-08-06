package com.clay.ge;

import com.clay.ge.io.GameKeys;
import com.clay.ge.render.GameColor;
import com.clay.ge.ui.GamePanel;
import com.clay.ge.ui.GameWindow;
import com.clay.ge.io.GameEvent;
import com.clay.ge.render.GameRender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferStrategy;

public abstract class GameApplication implements Runnable {
    private GameWindow window = new GameWindow();
    private GameEvent event = new GameEvent();
    private GameRender render = new GameRender();
    private GamePanel panel;

    private JFrame frame = new JFrame();
    private boolean running = true;
    private boolean showTitleFPS = false;

    public abstract void init(GameWindow window);

    public abstract void update(GameEvent event);

    public abstract void render(GameRender render);

    // Window Function

    public void CreateWindow(String title) {
        if (window == null) return;
        window.setTitle(title);
    }

    public void CreateWindow(String title, boolean resizable) {
        if (window == null) return;
        window.setTitle(title);
        window.setResizable(resizable);
    }

    public void CreateWindow(String title, int width, int height) {
        if (window == null) return;
        window.setTitle(title);
        window.setSize(width, height);
    }

    public void CreateWindow(String title, int width, int height, boolean resizable) {
        if (window == null) return;
        window.setTitle(title);
        window.setSize(width, height);
        window.setResizable(resizable);
    }

    public void CreateWindow(String title, int x, int y, int width, int height) {
        if (window == null) return;
        window.setTitle(title);
        window.setLocation(x, y);
        window.setSize(width, height);
    }

    public void CreateWindow(String title, int x, int y, int width, int height, boolean resizable) {
        if (window == null) return;
        window.setTitle(title);
        window.setLocation(x, y);
        window.setSize(width, height);
        window.setResizable(resizable);
    }

    public void SetBackgroundWindow(GameColor color) {
        window.setBackgroundColor(color);
    }

    public void ShowTitleFPS() {
        this.showTitleFPS = true;
    }

    public void HideTitleFPS() {
        this.showTitleFPS = false;
    }

    public String GetWindowTitle() {
        if (window == null) return "";
        return window.getTitle();
    }

    public int GetWindowPositionX() {
        if (window == null) return 0;
        return window.getX();
    }

    public int GetWindowPositionY() {
        if (window == null) return 0;
        return window.getY();
    }

    public int GetWindowWidth() {
        if (window == null) return -1;
        return window.getWidth();
    }

    public int GetWindowHeight() {
        if (window == null) return -1;
        return window.getHeight();
    }

    public boolean GetWindowResizable() {
        if (window == null) return false;
        return window.isResizable();
    }

    public void ClearWindow() {
        if (render == null) return;
        Graphics2D g = render.getGraphics();
        g.setColor(window.getBackgroundColor().toAWTColor());
        g.fillRect(0, 0, window.getWidth(), window.getHeight());
    }

    public void CloseWindow() {
        if (window == null) return;
        try { System.exit(0); } catch (RuntimeException e) { System.exit(1); }
    }

    // Event Function

    public boolean IsKeyPressed(GameKeys keys) {
        if (event == null) return false;
        return event.isKeyPressed(keys);
    }

    public boolean IsMouseButtonLeftPressed() {
        if (event == null) return false;
        return event.isMouseButtonPressed(GameMouse.BUTTON_LEFT);
    }

    public boolean IsMouseButtonMiddlePressed() {
        if (event == null) return false;
        return event.isMouseButtonPressed(GameMouse.BUTTON_MIDDLE);
    }

    public boolean IsMouseButtonRightPressed() {
        if (event == null) return false;
        return event.isMouseButtonPressed(GameMouse.BUTTON_RIGHT);
    }

    public boolean IsMouseButtonLeftClicked() {
        if (event == null) return false;
        return event.isMouseButtonClicked(GameMouse.BUTTON_LEFT);
    }

    public boolean IsMouseButtonMiddleClicked() {
        if (event == null) return false;
        return event.isMouseButtonClicked(GameMouse.BUTTON_MIDDLE);
    }

    public boolean IsMouseButtonRightClicked() {
        if (event == null) return false;
        return event.isMouseButtonClicked(GameMouse.BUTTON_RIGHT);
    }

    public int GetMouseX() {
        if (event == null) return 0;
        return event.getMouseX();
    }

    public int GetMouseY() {
        if (event == null) return 0;
        return event.getMouseY();
    }

    @Override
    public void run() {
        init(window);

        frame.setTitle(window.getTitle());
        frame.setSize(window.getWidth(), window.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(window.isResizable());
//        frame.setUndecorated(true);

        // gunakan BorderLayout supaya canvas isi seluruh frame
        frame.setLayout(new BorderLayout());

        panel = new GamePanel(window.getWidth(), window.getHeight(), window.getBackgroundColor());

        panel.canvas().addKeyListener(event);
        panel.canvas().addMouseListener(event);
        panel.canvas().addMouseMotionListener(event);
        panel.canvas().setFocusable(true);
        panel.canvas().requestFocusInWindow();

        // tambah canvas ke CENTER supaya saiz ikut frame
        frame.add(panel.canvas(), BorderLayout.CENTER);
        frame.pack();

        int x = window.getX();
        int y = window.getY();
        if (x == 0 && y == 0) {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            x = dim.width / 2 - window.getWidth() / 2;
            y = dim.height / 2 - window.getHeight() / 2;
            frame.setLocation(x, y);
        } else {
            frame.setLocation(x, y);
        }

        // pantau bila saiz berubah
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension size = panel.canvas().getSize();
                //System.out.println("Canvas resized to: " + size.width + "x" + size.height);
                // di sini anda boleh update sistem rendering, camera, viewport dll
                panel.canvas().setSize(size);
                window.setSize(size.width, size.height);
                init(window);
            }
        });

        frame.setVisible(window.isVisible());

        final int targetFPS = 60;
        final long frameTime = 1000000000 / targetFPS;

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            if (now - lastTime >= frameTime) {
                update(event);
                BufferStrategy bs = panel.bufferStrategy();
                if (bs == null) {
                    panel.createBufferStrategy(3);
                    continue;
                }
                Graphics g = bs.getDrawGraphics();
                render.setGraphics(g);
                render(render);
                g.dispose();
                bs.show();
                lastTime = now;
                frames++;
            }
            // Tunjuk FPS setiap saat
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS : " + frames);
                if (showTitleFPS) frame.setTitle(window.getTitle() + " | FPS : " + frames);
                frames = 0;
                timer += 1000;
            }
            Toolkit.getDefaultToolkit().sync();
        }
    }

    public static void launch(GameApplication app) {
        if (app == null) {
            System.out.println("launch: is null");
            return;
        }
        Thread thread = new Thread(app);
        thread.start();
    }

}

# Game-Engine-Library
Ini adalah contoh GameEngine yang sederhana yang di tulis menggunakan bahasa Java. Masih dalam pembangunan.

## Contoh Kod:

Demo.java
```java

import com.clay.ge.GameApplication;
import com.clay.ge.io.GameEvent;
import com.clay.ge.render.GameRender;
import com.clay.ge.ui.GameWindow;

public class Demo extends GameApplication {

    @Override
    public void init(GameWindow window) {
        CreateWindow("Demos");
        /* Write code here for init(GameWindow) */
    }

    @Override
    public void update(GameEvent event) {
        /* Write code here for update(GameEvent) */
    }

    @Override
    public void render(GameRender render) {
        ClearWindow();
        /* Write code here for render(GameRender) */
    }

    public static void main(String[] args) {
        launch(new Demos());
    }

}

```

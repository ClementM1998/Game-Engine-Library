package com.clay.ge.audio;

import java.awt.*;

public class GameAudio {
    private GameSound sound;
    private GameMusic music;

    public GameAudio() {}

    public GameAudio(GameSound sound, GameMusic music) {
        this.sound = sound;
        this.music = music;
    }

    public GameAudio(GameSound sound) {
        this.sound = sound;
    }

    public GameAudio(GameMusic music) {
        this.music = music;
    }

    public void playSound() {
        if (sound != null) sound.play();
    }

    public void stopSound() {
        if (sound != null) sound.stop();
    }

    public void playMusic() {
        if (music != null) music.play();
    }

    public void stopMusic() {
        if (music != null) music.stop();
    }

    public static void beep() {
        Toolkit.getDefaultToolkit().beep();
    }

}

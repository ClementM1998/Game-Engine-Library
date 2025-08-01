package com.clay.ge.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GameMusic {
    private Clip clip;

    public GameMusic(File file) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {}
    }

    public void play() {
        if (clip != null && !clip.isRunning()) clip.start();
    }

    public void stop() {
        if (clip != null && clip.isRunning()) clip.stop();
    }

}

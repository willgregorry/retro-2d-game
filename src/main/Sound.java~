package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL[] soundUrl = new URL[30];

    public Sound() {
        // Background Music
        soundUrl[0] = getClass().getResource("/sounds/bgm/bgm.wav");
        soundUrl[1] = getClass().getResource("/sounds/bgm/multimedia4.wav");

        // SFX
        soundUrl[2] = getClass().getResource("/sounds/sfx/dialogue.wav");
    }

    public void setFile(int i) {
        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }

}

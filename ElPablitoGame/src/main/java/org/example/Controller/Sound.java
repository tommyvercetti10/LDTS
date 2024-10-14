package org.example.Controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {
    private Clip sound;
    public Sound(String sound) { this.sound = loadSound(sound);}

    public boolean isPlaying(){return sound.isRunning();}

    private Clip loadSound(String sound) throws NullPointerException{
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            File musicFile = new File(rootPath+sound);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            return musicClip;
        } catch (Exception e) {
            System.out.println("Music " + sound );
        }
        return null;
    }

    public void startLoop() {
        sound.setMicrosecondPosition(0);
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY);
        sleep();
    }

    public void start() {
        sound.setMicrosecondPosition(0);
        sound.start();
        sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void stop() {sound.stop();}
}

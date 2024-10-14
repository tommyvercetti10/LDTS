package org.example.Controller;

import java.util.HashMap;
import java.util.Map;

public class SoundManager {
    private Map<String,Sound> sounds = new HashMap<>();
    private static SoundManager soundManager;

    private SoundManager() {
        sounds.put("soundtrack", new Sound("/src/resources/sounds/bgd2.wav"));
        sounds.put("carEngine", new Sound("/src/resources/sounds/engine.wav"));
        sounds.put("shoot", new Sound("/src/resources/sounds/shoot.wav"));
        sounds.put("crash", new Sound("/src/resources/sounds/crash.wav"));
        sounds.put("sirens", new Sound("/src/resources/sounds/sirens.wav"));
        sounds.put("gameOver", new Sound("/src/resources/sounds/gameOver.wav"));
        sounds.put("caught", new Sound("/src/resources/sounds/caught.wav"));
    }

    public static SoundManager getInstance() {
        if (soundManager == null) {
            soundManager = new SoundManager();
        }
        return soundManager;
    }

    public void start(String sound) {
        if (sound.equals("soundtrack") || sound.equals("carEngine") || sound.equals("sirens")) sounds.get(sound).startLoop();
        else sounds.get(sound).start();
    }

    public boolean isPlaying(String sound) {
        if (sounds.get(sound) != null) return sounds.get(sound).isPlaying();
        else return false;
    }

    public void stop(String sound) {
        sounds.get(sound).stop();
    }

    public void stopAll() {
        for (Map.Entry<String, Sound> sound : sounds.entrySet()) sound.getValue().stop();
    }
}

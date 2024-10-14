package org.example.Controller;

import org.example.Model.Elements.Character;
import org.example.States.*;

import java.io.IOException;

public class Controller {
    private StateController stateController;
    private ApplicationState applicationState;
    private Character character = new Character(0,0);

    public Controller() throws IOException {updateState(ApplicationState.MainMenu, character);}
    public void run() throws IOException {
        while (stateController != null){
            stateController.run();
        }
        System.exit(0);
    }
    public void updateState(ApplicationState state, Character character) throws IOException {
        applicationState = state;
        switch (state){
            case Game -> {
                if (!SoundManager.getInstance().isPlaying("soundtrack")) {
                    SoundManager.getInstance().start("soundtrack");
                }
                SoundManager.getInstance().start("sirens");
                stateController= new GameController(this); }
            case MainMenu -> { 
                SoundManager.getInstance().stopAll();
                SoundManager.getInstance().start("soundtrack");
                stateController = new MenuController(this);}
            case GameOver -> {
                SoundManager.getInstance().stopAll();
                SoundManager.getInstance().start("gameOver");
                stateController = new GameOverController(this, character); }
            case Exit ->{
                stateController = null;
            }
        }
    }

    // Getters and Setters
    public StateController getStateController() { return stateController; }

    public ApplicationState getApplicationState() { return applicationState; }
}

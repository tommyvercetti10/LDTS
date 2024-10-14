package org.example.States;

import org.example.Controller.Controller;
import org.example.Model.Elements.Character;
import org.example.Model.Menus.GameOver;
import org.example.Viewer.GameOverViewer;
import org.example.Viewer.ScreenView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GameOverController implements StateController, KeyListener {
    private final Controller context;
    private final ScreenView gameOverViewer;
    private final GameOver gameOver;
    private Character character;

    public GameOverController(Controller context, Character character) throws IOException{
        this.context = context;
        this.gameOver = new GameOver();
        this.character = character;
        this.gameOverViewer = new GameOverViewer(gameOver, character);
    }

    @Override
    public void run() throws IOException {
        gameOverViewer.addKeyListener(this);

        while (context.getApplicationState() == ApplicationState.GameOver) {
            gameOverViewer.draw();

            if(gameOver.wasChosen())
                nextState();
        }
        gameOverViewer.getScreen().stopScreen();
    }

    @Override
    public void nextState() throws IOException {
        switch (gameOver.getSelected()){
            case "RESTART":
                context.updateState(ApplicationState.Game, character);
                break;
            case "EXIT":
                context.updateState(ApplicationState.Exit, character);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN, KeyEvent.VK_UP:
                gameOver.select();
                break;
            case KeyEvent.VK_ENTER:
                gameOver.setChosen(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

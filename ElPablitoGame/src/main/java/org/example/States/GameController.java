package org.example.States;

import org.example.Screen;
import org.example.Controller.CharacterController;
import org.example.Controller.Controller;
import org.example.Model.GameModel;
import org.example.Viewer.GameViewer;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class GameController implements StateController {
    private GameModel gameModel;
    private GameViewer gameViewer;
    private final Controller context;
    private final CharacterController characterController;
    private final int FRAME_TIME = 50;

    public GameController(Controller context) throws IOException {
        this.context = context;
        this.gameViewer = new GameViewer(Screen.WIDTH, Screen.HEIGHT);
        gameViewer.setMaxCol(10);
        gameViewer.setMaxRow(10);
        gameViewer.setTileSize(32);
        this.gameModel = new GameModel(gameViewer);
        this.characterController = new CharacterController(gameModel.getCharacter());
    }

    @Override
    public void run() throws IOException {
        gameViewer.addKeyListener(characterController);

        long past = System.currentTimeMillis();
        long lastUpdate = 0L;

        while (context.getApplicationState() == ApplicationState.Game) {
            long present = System.currentTimeMillis();
            long deltaTime = present - past;

            lastUpdate += deltaTime;
            lastUpdate = update(lastUpdate);

            gameViewer.draw();
            if(gameModel.getCharacter().getHP()==0){
                nextState();
            }

            past = present;
        }
        gameViewer.getScreen().close();
    }

    @Override
    public void nextState() throws IOException {
        context.updateState(ApplicationState.GameOver, characterController.getCharacter());
    }

    public long update(long lastUpdate){
        while(lastUpdate >= FRAME_TIME) {
            gameModel.update(FRAME_TIME);
            lastUpdate -= FRAME_TIME;
        }
        return  lastUpdate;
    }
}

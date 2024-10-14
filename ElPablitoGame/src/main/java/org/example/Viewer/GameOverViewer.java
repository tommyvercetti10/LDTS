package org.example.Viewer;

import com.googlecode.lanterna.terminal.Terminal;
import org.example.Screen;
import org.example.Model.Elements.Character;
import org.example.Model.Menus.GameOver;
import org.example.Model.Position;
import org.example.PixelFont;

import java.io.IOException;

public class GameOverViewer extends ScreenView{
    private GameOver gameOver;
    private PixelFont pixelFont;
    private Character character;
    public GameOverViewer(GameOver gameOver, Character character) throws IOException{
        this.gameOver = gameOver;
        this.character = character;
        Terminal terminal = createTerminal(Screen.WIDTH, Screen.HEIGHT);
        setScreen(createScreen(terminal));
        setGraphics(getScreen().newTextGraphics());
        pixelFont = new PixelFont(this);
    }

    @Override
    public void draw() throws IOException {
        getScreen().clear();

        pixelFont.drawText("GAME", new Position((double) Screen.WIDTH / 2 - 100, 80), 20, "#FF0000", 4);
        pixelFont.drawText("OVER", new Position((double) Screen.WIDTH / 2 -10, 80), 20, "#FF0000", 4);

        pixelFont.drawText("RESULTS", new Position((double) Screen.WIDTH / 2-80, 120), 20, "#A0A0A0", 4);

        pixelFont.drawText("XP", new Position((double) Screen.WIDTH / 2 -50, 160), 13, "#A0A0A0", 3);
        pixelFont.drawNumber(Integer.toString(character.getXP()), new Position((double) Screen.WIDTH / 2 -20, 160), 13, "#A0A0A0", 3);

        pixelFont.drawText("CASH", new Position((double) Screen.WIDTH / 2 -60, 190), 13, "#A0A0A0", 3);
        pixelFont.drawNumber(Integer.toString(character.getCash()), new Position((double) Screen.WIDTH / 2, 190), 13, "#A0A0A0", 3);

        pixelFont.drawText("DRUGS", new Position((double) Screen.WIDTH / 2 -70, 220), 13, "#A0A0A0", 3);
        pixelFont.drawNumber(Integer.toString(character.getDrugs()), new Position((double) Screen.WIDTH / 2+10, 220), 13, "#A0A0A0", 3);

        int sum = 0;
        int sum2= 10;

        for (int i = 0; i < gameOver.getOptions().length; i++) {
            String colorFont;
            if (gameOver.getOptions()[i].equals(gameOver.getSelected())) colorFont = "#FFFF00";
            else colorFont = "#FFFFFF";
            pixelFont.drawText(gameOver.getOptions()[i], new Position((double) Screen.WIDTH / 2 - 30-sum2, 300 + sum), 10, colorFont, 3);
            sum2-=10;
            sum += 30;
        }

        getScreen().refresh();
    }
    public void setCharacter(Character character){
        this.character = character;
    }
}

package org.example.Viewer;

import com.googlecode.lanterna.terminal.Terminal;
import org.example.Screen;
import org.example.Model.*;
import org.example.Model.Elements.Character;
import org.example.Model.Elements.Bullet;
import org.example.Model.Elements.Element;
import org.example.Model.Elements.Items.Cash;
import org.example.Model.Elements.Items.Drugs;
import org.example.Model.Elements.Items.Fuel;
import org.example.Model.Elements.Enemies.PoliceCar;
import org.example.PixelFont;
import org.example.Viewer.Elements.BulletViewer;
import org.example.Viewer.Elements.CharacterViewer;
import org.example.Viewer.Elements.ElementViewer;
import org.example.Viewer.Elements.Enemies.PoliceCarViewer;
import org.example.Viewer.Elements.Items.CashViewer;
import org.example.Viewer.Elements.Items.DrugsViewer;
import org.example.Viewer.Elements.Items.FuelViewer;

import java.io.IOException;

public class GameViewer extends ScreenView {
    private int width, height;
    private int maxCol, maxRow;
    private int tileSize;
    private GameModel gameModel;
    private PixelFont pixelFont;

    public GameViewer(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        Terminal terminal = createTerminal(width, height);
        setScreen(createScreen(terminal));
        setGraphics(getScreen().newTextGraphics());
        this.pixelFont = new PixelFont(this);
    }
    @Override
    public void draw() throws IOException {
        getScreen().clear();

        for (int i = 0; i < gameModel.getElements().size(); i++) {
            ElementViewer view = null;
            Element element = gameModel.getElements().get(i);
            if (element instanceof Character) view = new CharacterViewer(gameModel.getCharacter());
            else if (element instanceof Bullet) view = new BulletViewer((Bullet) element);
            else if (element instanceof PoliceCar) view = new PoliceCarViewer((PoliceCar) element);
            else if (element instanceof Fuel) view = new FuelViewer((Fuel) element);
            else if (element instanceof Drugs) view = new DrugsViewer((Drugs) element);
            else if (element instanceof Cash) view = new CashViewer((Cash) element);
            if (view != null) view.draw(getGraphics());
        }

        pixelFont.drawText("HP", new Position(0, 5), 10, "#FFFFFF", 2);
        pixelFont.drawNumber(Integer.toString(gameModel.getCharacter().getHP()), new Position(25, 5), 10, "#FFFFFF", 2);
        pixelFont.drawText("FUEL", new Position(60, 5), 10, "#FFFFFF", 2);
        pixelFont.drawNumber(Integer.toString((int)gameModel.getCharacter().getFuel()), new Position(110, 5), 10, "#FFFFFF", 2);
        pixelFont.drawText("XP", new Position(Screen.WIDTH - 50, 5), 10, "#FFFFFF", 2);
        pixelFont.drawNumber(Integer.toString(gameModel.getCharacter().getXP()), new Position(Screen.WIDTH - 20, 5), 10, "#FFFFFF", 2);

        getScreen().refresh();
    }

    //region GETTERS && SETTERS
    public void setMaxCol(int maxCol) { this.maxCol = maxCol;}
    public int getMaxCol() { return this.maxCol;}
    public void setMaxRow(int maxRow) { this.maxRow = maxRow;}
    public int getMaxRow() { return this.maxRow;}
    public void setTileSize(int tileSize) { this.tileSize = tileSize;}
    public int getTileSize() { return this.tileSize;}
    public int getWidth() {return this.width;}
    public int getHeight() { return this.height;}
    public void setGameModel(GameModel gameModel) { this.gameModel = gameModel;}
    //endregion
}

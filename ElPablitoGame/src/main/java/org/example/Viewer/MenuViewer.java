package org.example.Viewer;

import com.googlecode.lanterna.terminal.Terminal;
import org.example.Screen;
import org.example.Model.Menus.MainMenu;
import org.example.Model.Position;
import org.example.PixelFont;

import java.io.IOException;

public class MenuViewer extends ScreenView {
    private MainMenu menu;
    private PixelFont pixelFont;

    public MenuViewer(MainMenu menu) throws IOException {
        this.menu = menu;
        Terminal terminal = createTerminal(Screen.WIDTH, Screen.HEIGHT);
        setScreen(createScreen(terminal));
        setGraphics(getScreen().newTextGraphics());
        pixelFont = new PixelFont(this);
    }

    @Override
    public void draw() throws IOException {

        getScreen().clear();

        pixelFont.drawText("EL", new Position((double) Screen.WIDTH / 2 - 100, 110), 20, "#FFFFFF", 4);
        pixelFont.drawText("PABLITO", new Position((double) Screen.WIDTH / 2 - 35, 110), 20, "#FFFFFF", 4);
        int sum = 0;

        for (int i = 0; i < menu.getOptions().length; i++) {
            String colorFont;
            if (menu.getOptions()[i].equals(menu.getSelected())) colorFont = "#FFFF00";
            else colorFont = "#FFFFFF";
            pixelFont.drawText(menu.getOptions()[i], new Position((double) Screen.WIDTH / 2 - 30, 150 + sum), 10, colorFont, 3);
            sum = 30;
        }

        getScreen().refresh();
    }
}

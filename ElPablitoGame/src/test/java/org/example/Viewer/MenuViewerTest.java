package org.example.Viewer;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.example.Model.Menus.MainMenu;
import org.example.Model.Position;
import org.example.PixelFont;
import org.example.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    TextGraphics textGraphics;
    MenuViewer menuViewer;
    MainMenu menu;
    PixelFont pixelFont;
    TerminalScreen terminalScreen;
    ScreenView screenView;
    @BeforeEach
    void setUp() throws IOException {
        terminalScreen = menuViewer.getScreen();
        menu = new MainMenu();
        menuViewer = new MenuViewer(menu);
        pixelFont = Mockito.mock(PixelFont.class);
    }
    @Test
    void drawMenu() throws IOException {
        menuViewer.draw();
        Mockito.verify(pixelFont, Mockito.times(1)).drawText("EL", new Position((double) Screen.WIDTH / 2 - 100, 110), 20, "#FFFFFF", 4);
        Mockito.verify(pixelFont, Mockito.times(1)).drawText("PABLITO", new Position((double) Screen.WIDTH / 2 - 35, 110), 20, "#FFFFFF", 4);
    }

}

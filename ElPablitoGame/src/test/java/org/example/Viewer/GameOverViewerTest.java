package org.example.Viewer;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Model.Elements.Character;
import org.example.Model.Menus.GameOver;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.Text;

import java.io.IOException;

public class GameOverViewerTest {
    GameOverViewer gameOverViewer;

    @Test
    void draw() throws IOException {
        GameOver gameOverMock = Mockito.mock(GameOver.class);
        Character characterMock = Mockito.mock(Character.class);
        gameOverViewer = Mockito.spy(new GameOverViewer(gameOverMock, characterMock));
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        gameOverViewer.setGraphics(graphics);

        gameOverViewer.draw();

        Mockito.verify(gameOverViewer, Mockito.times(1)).getScreen().refresh();
    }
}

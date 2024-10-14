package org.example.Viewer;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Model.Elements.Character;
import org.example.Model.Elements.Element;
import org.example.Model.GameModel;
import org.example.Screen;
import org.example.Viewer.Elements.CharacterViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameVIewerTest {
    GameViewer gameViewer;
    Character character;
    GameModel gameModel;
    List<Element> elements;
    TextGraphics graphics;

    @BeforeEach
    void setUp() throws IOException {
        gameViewer = new GameViewer(Screen.WIDTH, Screen.HEIGHT);
        gameModel = Mockito.mock(GameModel.class);
        graphics = Mockito.mock(TextGraphics.class);
        elements = new ArrayList<>();
        gameViewer.setGraphics(graphics);
        Mockito.when(gameModel.getElements()).thenReturn(elements);
    }

    @Test
    void drawPlayer() throws IOException {
        Character character = Mockito.mock(Character.class);
        CharacterViewer view = Mockito.mock(CharacterViewer.class);
        elements.add(character);
        gameViewer.draw();

        Mockito.verify(view, Mockito.times(1)).draw(graphics);

    }
}

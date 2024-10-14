package org.example.Model.Elements;

import org.example.Model.Position;
import org.example.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ElementTest {
    Element element;
    Position position;

    @BeforeEach
    void setUpElement() {
        element = Mockito.mock(Element.class, Mockito.CALLS_REAL_METHODS);
        position = Mockito.mock(Position.class);
        element.setHeight(32);
        element.setWidth(32);
        element.setPosition(position);
    }
    @Test
    void LeftBoundary() {
        for (int i = 4; i > -5; i--) {
            Position pos = new Position(i, 6);
            //element.setPosition(pos);
            assertFalse(element.checkBoundary(pos));
        }
    }

    @Test
    void RightBoundary() {
        for (int i = Screen.WIDTH -4; i < Screen.WIDTH + 5; i++) {
            Position pos = new Position(Screen.WIDTH, 6);
            assertFalse(element.checkBoundary(pos));
        }
    }
    @Test
    void UpBoundary() {
        for (int i = 5; i > -5; i--) {
            Position pos = new Position(6, i);
            assertFalse(element.checkBoundary(pos));
        }
    }
    @Test
    void DownBoundary() {
        for (int i = Screen.HEIGHT -5; i < Screen.HEIGHT + 4; i++) {
            Position pos = new Position(6, i);
            assertFalse(element.checkBoundary(pos));
        }
    }

}

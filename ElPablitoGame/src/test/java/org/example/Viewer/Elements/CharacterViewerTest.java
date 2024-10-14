package org.example.Viewer.Elements;


import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Model.Elements.Character;
import org.example.Model.Position;
import org.example.Model.RotationPoint;
import org.example.Viewer.Elements.CharacterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class CharacterViewerTest {
    Character characterMock;
    Position positionMock;
    TextGraphics graphicsMock;
    CharacterViewer characterViewer;
    String[] image;

    @BeforeEach
    void setup() throws IOException {
        this.image = new Image().loadString("src/resources/images/characterCar.png");
        characterMock = Mockito.mock(Character.class);
        Mockito.when(characterMock.getAngle()).thenReturn(10.0);
        positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.getX()).thenReturn(10.0);
        Mockito.when(positionMock.getY()).thenReturn(20.0);
        Mockito.when(characterMock.getPosition()).thenReturn(positionMock);
        characterViewer = Mockito.spy(new CharacterViewer(characterMock));
        graphicsMock = Mockito.mock(TextGraphics.class);
    }

    @Test
    void drawElements() {
        //given
        double angle = 10;
        int posX = 10;
        int posY = 20;
        double mid = (double) image.length / 2;
        //when
        characterViewer.drawElement(image, angle, graphicsMock, posX , posY);
        //then
        for(int y = 0; y < image.length; y++){
            String[] c = image[y].split("-");
            for(int x = 0; x < image.length; x++){
                if(!c[x].equals("*")){
                    RotationPoint point = new RotationPoint(x- mid, y - mid);
                    RotationPoint newPoint = point.rotationPoint(angle);
                    graphicsMock.setBackgroundColor(TextColor.Factory.fromString(c[x]));
                    Mockito.verify(graphicsMock, Mockito.times(1)).fillRectangle(new TerminalPosition((int) (posX + (newPoint.getX() * 1)), (int)(posY + (newPoint.getY() * 1))),
                            new TerminalSize(1, 1), ' ');
                }
            }
        }

    }
}
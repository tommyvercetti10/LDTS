package org.example.Viewer.Elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Model.Elements.Bullet;
import org.example.Model.Elements.Character;
import org.example.Model.Position;
import org.example.Model.RotationPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

public class BulletViewerTest {
    Bullet bulletMock;
    Position positionMock;
    BulletViewer bulletViewer;
    TextGraphics graphicsMock;
    String[] image;

    @BeforeEach
    void setup() throws IOException {
        this.image = new Image().loadString("src/resources/images/bullet.png");
        bulletMock = Mockito.mock(Bullet.class);
        positionMock = Mockito.mock(Position.class);
        Mockito.when(positionMock.getX()).thenReturn(10.0);
        Mockito.when(positionMock.getY()).thenReturn(20.0);
        Mockito.when(bulletMock.getPosition()).thenReturn(positionMock);
        Mockito.when(bulletMock.getWidth()).thenReturn(4.0);
        Mockito.when(bulletMock.getHeight()).thenReturn(4.0);
        bulletViewer = Mockito.spy(new BulletViewer(bulletMock));
        graphicsMock = Mockito.mock(TextGraphics.class);
    }

    @Test
    void drawElements() {
        //given
        double angle = 10;
        int posX = 10;
        int posY = 20;
        //when
        bulletViewer.drawElement(image, angle, graphicsMock, posX , posY);
        //then
        for(int y = 0; y < image.length; y++){
            String[] c = image[y].split("-");
            for(int x = 0; x < image.length; x++){
                if(!c[x].equals("*")){
                    graphicsMock.setBackgroundColor(TextColor.Factory.fromString(c[x]));
                    Mockito.verify(graphicsMock, Mockito.times(1)).fillRectangle(new TerminalPosition(posX + x, posY + y),
                            new TerminalSize(1, 1), ' ');
                }
            }
        }

    }
}

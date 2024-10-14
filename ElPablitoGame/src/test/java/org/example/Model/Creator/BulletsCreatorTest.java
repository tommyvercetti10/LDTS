package org.example.Model.Creator;

import org.example.Model.Elements.Element;
import org.example.Model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BulletsCreatorTest {
    BulletsCreator bulletsCreator;
    List<Element> entities;
    @BeforeEach
    void init() {
        entities = Mockito.mock(List.class);
        bulletsCreator = new BulletsCreator(entities) {
            @Override
            public Element create() {
                return null;
            }
        };

    }
    @Test
    void add() {

        // given
        Element element = Mockito.mock(Element.class);

        // when
        bulletsCreator.addBullet(element);

        // then
        Mockito.verify(entities, Mockito.times(1)).add(element);
    }
    @Test
    void getEntities() {

        // when
        List<Element> returned = bulletsCreator.getElements();

        // then
        assertEquals(returned, entities);
    }

    @Test
    public void nextPos() {
        // given
        Element shooter = Mockito.mock(Element.class);
        Mockito.when(shooter.getWidth()).thenReturn(10.0);
        Mockito.when(shooter.getHeight()).thenReturn(15.0);

        Position shooterPosition = Mockito.mock(Position.class);

        Mockito.when(shooter.getPosition()).thenReturn(shooterPosition);



        Mockito.when(shooterPosition.getX()).thenReturn(6.0);
        Mockito.when(shooterPosition.getY()).thenReturn(7.0);

        double angle = 10;
        int bulletWidth = 3;
        int bulletHeight = 3;

        double distance = Math.sqrt(Math.pow(shooter.getWidth() / 2, 2) + Math.pow(shooter.getHeight() / 2, 2));
        double x = Math.cos(angle)*(distance/2 + bulletWidth+1);
        double y = Math.sin(angle)*(distance/2 + bulletHeight+1);

        // when
        Position result = bulletsCreator.nextPos(angle, shooter);
        // then
        //assertEquals(pClone, result);
        assertEquals(x, result.getX());
        assertEquals(y, result.getY());
    }
}

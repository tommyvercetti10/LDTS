package org.example.Model.Collider;

import org.example.Model.Elements.Element;
import org.example.Model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollidableObjectTest {
    CollidableObject collidableObject1;
    CollidableObject collidableObject2;
    Element element1, element2;
    @BeforeEach
    void setUp(){
        collidableObject1 = Mockito.mock(CollidableObject.class, Mockito.CALLS_REAL_METHODS);
        collidableObject2 = Mockito.mock(CollidableObject.class, Mockito.CALLS_REAL_METHODS);

        element1 = Mockito.mock(Element.class, Mockito.CALLS_REAL_METHODS);
        element2 = Mockito.mock(Element.class, Mockito.CALLS_REAL_METHODS);

        Mockito.when(collidableObject1.getElement()).thenReturn(element1);
        Mockito.when(collidableObject2.getElement()).thenReturn(element2);
    }

    @Test
    void collide() {
        //given
        Position pos1 = new Position(10, 10);
        element1.setPosition(pos1);
        element1.setWidth(32);
        element1.setHeight(32);
        Position pos2 = new Position(12, 12);
        element2.setPosition(pos2);
        element2.setWidth(32);
        element2.setHeight(32);
        //when
        boolean colide = collidableObject1.collide(collidableObject2);

        //then
        assertTrue(colide);
    }

    @Test
    void dontcollide() {
        //given
        Position pos1 = new Position(10, 10);
        element1.setPosition(pos1);
        element1.setWidth(32);
        element1.setHeight(32);
        Position pos2 = new Position(100, 100);
        element2.setPosition(pos2);
        element2.setWidth(32);
        element2.setHeight(32);
        //when
        boolean colide = collidableObject1.collide(collidableObject2);

        //then
        assertFalse(colide);
    }

    @Test
    void collideInverse() {
        //given
        Position pos1 = new Position(10, 10);
        element1.setPosition(pos1);
        element1.setWidth(32);
        element1.setHeight(32);
        Position pos2 = new Position(12, 12);
        element2.setPosition(pos2);
        element2.setWidth(32);
        element2.setHeight(32);
        //when
        boolean colide = collidableObject2.collide(collidableObject1);

        //then
        assertTrue(colide);
    }
}

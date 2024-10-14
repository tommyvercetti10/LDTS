package org.example.Model;
import org.example.Model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {

    private Position position;
    @BeforeEach
    void setup(){
        position = new Position(10, 20);
    }
    @Test
    void testPosition(){
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());

    }
    @Test
    void testSets(){
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());

        position.setX(20);
        position.setY(40);

        assertEquals(20, position.getX());
        assertEquals(40, position.getY());
    }
}

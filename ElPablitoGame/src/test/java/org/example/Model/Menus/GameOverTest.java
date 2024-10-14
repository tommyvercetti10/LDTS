package org.example.Model.Menus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverTest {
    @Test
    void testSets() {
        GameOver gameOver = new GameOver();
        String[] stringTest = new String[]{"RESTART", "EXIT"};
        assertEquals(gameOver.getSelected(), "RESTART");
        assertFalse(gameOver.wasChosen());
        assertArrayEquals(gameOver.getOptions(), stringTest);
    }
}

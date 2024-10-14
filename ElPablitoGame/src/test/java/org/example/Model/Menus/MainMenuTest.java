package org.example.Model.Menus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuTest {
    @Test
    void testSets() {
        MainMenu mainMenu = new MainMenu();
        String[] stringTest = new String[]{"PLAY", "EXIT"};
        assertEquals(mainMenu.getSelected(), "PLAY");
        assertFalse(mainMenu.wasChosen());
        assertArrayEquals(mainMenu.getOptions(), stringTest);
    }
}

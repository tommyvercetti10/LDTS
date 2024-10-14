package org.example.Model.Menus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    Menu menu;

    @BeforeEach
    void initMenu() {
        menu = Mockito.mock(Menu.class, Mockito.CALLS_REAL_METHODS);
    }


    @Test
    void choose(){
        // when
        boolean choose1 = menu.wasChosen();
        menu.setChosen(true);
        boolean choose2 =menu.wasChosen();

        // then
        assertFalse(choose1);
        assertTrue(choose2);
    }

    @Test
    void selectMainMenu(){
        //given
        MainMenu mainMenu = new MainMenu();
        //when
        mainMenu.select();
        String select1 = mainMenu.getSelected();
        mainMenu.select();
        String select2 = mainMenu.getSelected();
        //then
        assertEquals(mainMenu.getOptions()[1], select1);
        assertEquals(mainMenu.getOptions()[0], select2);
    }

    @Test
    void selectGameOver(){
        //given
        GameOver gameOver = new GameOver();
        //when
        gameOver.select();
        String select1 = gameOver.getSelected();
        gameOver.select();
        String select2 = gameOver.getSelected();
        //then
        assertEquals(gameOver.getOptions()[1], select1);
        assertEquals(gameOver.getOptions()[0], select2);
    }
}

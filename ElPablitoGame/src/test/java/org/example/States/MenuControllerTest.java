package org.example.States;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.sun.tools.javac.Main;
import org.example.Controller.Controller;
import org.example.Model.Menus.MainMenu;
import org.example.Viewer.ScreenView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MenuControllerTest {
    MenuController menuController;
    Controller context;
    MainMenu mainMenu;
    ScreenView screenViewMock;
    TerminalScreen terminalScreenMock;
    @BeforeEach
    void setUpGameController() throws IOException {
        // create context
        context = Mockito.mock(Controller.class);

        // create MenuController
        menuController = Mockito.spy(new MenuController(context));

        // create menuMoCK
        mainMenu = Mockito.mock(MainMenu.class);
        Mockito.when(menuController.getMenu()).thenReturn(mainMenu);

        // create screens Mocks
        screenViewMock = Mockito.mock(ScreenView.class);
        terminalScreenMock = Mockito.mock(TerminalScreen.class);
        Mockito.when(screenViewMock.getScreen()).thenReturn(terminalScreenMock);
        Mockito.when(menuController.getMenuViewer()).thenReturn(screenViewMock);
    }

    @Test
    void processKeyArrowDown() {
        //given
        KeyEvent e = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0, KeyEvent.VK_DOWN, KeyEvent.CHAR_UNDEFINED);
        //when
        menuController.keyPressed(e);
        //then
        Mockito.verify(mainMenu, Mockito.times(1)).select();
    }

    @Test
    void processKeyArrowUp() {
        //given
        KeyEvent e = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        //when
        menuController.keyPressed(e);
        //then
        Mockito.verify(mainMenu, Mockito.times(1)).select();
    }
    @Test
    void processKeyEnter(){
        // given
        KeyEvent e = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0, KeyEvent.VK_ENTER, '\n');

        // when
        menuController.keyPressed(e);

        // then
        Mockito.verify(mainMenu, Mockito.times(1)).setChosen(true);
    }

    @Test
    void startRun() throws IOException {
        menuController.run();

        Mockito.verify(screenViewMock,Mockito.times(1)).addKeyListener(menuController);

    }
}



package org.example.Controller;

import org.example.Model.Collider.CollidableObject;
import org.example.Model.Elements.Character;
import org.example.States.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    Controller controllerSpy;
    Character character;

    @BeforeEach
    void setUp() throws IOException {
        //SoundManager manager= Mockito.mock(SoundManager .class);
        //try(MockedStatic<SoundManager > configurationMockedStatic=Mockito.mockStatic(SoundManager.class)) {
          //  configurationMockedStatic.when(SoundManager::getInstance).thenReturn(manager);

            Controller controller = new Controller();
            //controllerSpy = Mockito.spy(controller);
            controllerSpy = Mockito.mock(Controller.class, Mockito.CALLS_REAL_METHODS);
            character = Mockito.mock(Character.class);
       //}
    }

   @Test
   void updateStateGame() throws IOException {
        //SoundManager manager= Mockito.mock(SoundManager.class);
        //try(MockedStatic<SoundManager> configurationMockedStatic=Mockito.mockStatic(SoundManager.class)) {
          //  configurationMockedStatic.when(SoundManager::getInstance).thenReturn(manager);

            //when
            controllerSpy.updateState(ApplicationState.Game, character);
            //then
            assertTrue(controllerSpy.getStateController() instanceof GameController);
            assertEquals(controllerSpy.getApplicationState(), ApplicationState.Game);
        //}
    }

    @Test
    void updateStateMainMenu() throws IOException {
        //when
        controllerSpy.updateState(ApplicationState.MainMenu, character);
        //then
        assertTrue(controllerSpy.getStateController() instanceof MenuController);
        assertEquals(controllerSpy.getApplicationState(), ApplicationState.MainMenu);
    }

    @Test
    void updateStateGameOver() throws IOException {
        //when
        controllerSpy.updateState(ApplicationState.GameOver, character);
        //then
        assertTrue(controllerSpy.getStateController() instanceof GameOverController);
        assertEquals(controllerSpy.getApplicationState(), ApplicationState.GameOver);
    }
    @Test
    void updateExit() throws IOException {
        //when
        controllerSpy.updateState(ApplicationState.Exit, character);
        //then
        assertNull(controllerSpy.getStateController());
        assertEquals(controllerSpy.getApplicationState(), ApplicationState.Exit);
    }
    @Test
    void runState() throws IOException {
        GameController gameControllerMock = Mockito.mock(GameController.class);
        Mockito.when(controllerSpy.getStateController()).thenReturn(gameControllerMock);
        controllerSpy.run();
        Mockito.verify(controllerSpy.getStateController(), Mockito.times(1)).run();
    }

}

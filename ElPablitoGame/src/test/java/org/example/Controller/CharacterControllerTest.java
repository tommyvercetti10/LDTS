package org.example.Controller;

import org.example.Model.Elements.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CharacterControllerTest {
    Character character;
    CharacterController characterController;
    KeyEvent left;
    KeyEvent right;
    KeyEvent up;
    KeyEvent space;
    List<KeyEvent> keyEventList;
    @BeforeEach
    void setUp() {
        character = Mockito.mock(Character.class);
        characterController = new CharacterController(character);
        keyEventList = new ArrayList<>();
        left = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        right = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        up = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        space = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_SPACE, ' ');


        for(int k = 0; k < 256; k++){
            KeyEvent e = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                    k, KeyEvent.CHAR_UNDEFINED);
            keyEventList.add(e);
        }
    }

    @Test
    void changeDirectionLeft() {
        KeyEvent e = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        characterController.keyPressed(e);
        Mockito.verify(character, Mockito.times(1)).setMovement(Movement.Left);
        characterController.keyReleased(e);
        Mockito.verify(character, Mockito.times(1)).setMovement(Movement.None);
    }

    @Test
    void changeDirectionRight() {
        KeyEvent e = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        characterController.keyPressed(e);
        Mockito.verify(character, Mockito.times(1)).setMovement(Movement.Right);
        characterController.keyReleased(e);
        Mockito.verify(character, Mockito.times(1)).setMovement(Movement.None);
    }
    @Test
    void aceleration(){
            characterController.keyPressed(up);
            Mockito.verify(character, Mockito.times(1)).setAcelerate(true);

            characterController.keyReleased(up);
            Mockito.verify(character, Mockito.times(1)).setAcelerate(false);
    }
    @Test
    void shoot() {
        characterController.keyPressed(space);
        Mockito.verify(character, Mockito.times(1)).setShoot(true);

        characterController.keyReleased(space);
        Mockito.verify(character, Mockito.times(1)).setShoot(false);
    }

    @Test
    void othersKeys() {
        for(KeyEvent keyEvent : keyEventList) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_RIGHT
                    || keyEvent.getKeyCode() == KeyEvent.VK_LEFT
                    || keyEvent.getKeyCode() == KeyEvent.VK_UP
                    || keyEvent.getKeyCode() == KeyEvent.VK_SPACE)
                continue;
            characterController.keyPressed(keyEvent);
            Mockito.verify(character, Mockito.never()).setMovement(Mockito.any());
            Mockito.verify(character, Mockito.never()).setShoot(Mockito.anyBoolean());
            Mockito.verify(character, Mockito.never()).setAcelerate(Mockito.anyBoolean());
        }
    }
}

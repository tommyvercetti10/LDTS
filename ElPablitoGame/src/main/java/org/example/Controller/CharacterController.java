package org.example.Controller;

import org.example.Model.Elements.Character;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterController implements KeyListener {
    private final Character character;
    public CharacterController(Character character) {
        this.character = character;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed (KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                character.setMovement(Movement.Left);
                break;
            case KeyEvent.VK_RIGHT:
                character.setMovement(Movement.Right);
                break;
            case KeyEvent.VK_UP:
                character.setAcelerate(true);
                SoundManager.getInstance().start("carEngine");
                break;
            case KeyEvent.VK_SPACE:
                character.setShoot(true);
                SoundManager.getInstance().start("shoot");
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT:
                character.setMovement(Movement.None);
                break;
            case KeyEvent.VK_UP:
                character.setAcelerate(false);
                SoundManager.getInstance().stop("carEngine");
                break;
            case KeyEvent.VK_SPACE:
                character.setShoot(false);
        }
    }

    public Character getCharacter(){
        return character;
    }
}

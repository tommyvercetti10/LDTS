package org.example.Model.Elements;

import org.example.Controller.Movement;
import org.example.Model.Creator.BulletsCreator;
import org.example.Model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CharacterTest {
    @Test
    void createCharacter() {
        //given
        int x = 10;
        int y = 15;
        Character character = new Character(x, y);
        //when
        Position position = character.getPosition();
        //then
        assertEquals(position.getX(), x);
        assertEquals(position.getY(), y);
    }

    @Test
    void shootUpdate() {
        //given
        Character character = new Character(10, 15);
        BulletsCreator bulletsCreatorMock = Mockito.mock(BulletsCreator.class);
        character.setBulletsCreator(bulletsCreatorMock);
        //when
        character.setShoot(true);
        character.move(50);
        //then
        Mockito.verify(bulletsCreatorMock, Mockito.times(1)).addBullet(Mockito.any());
        assertFalse(character.getShoot());
    }
    @Test
    void rotate() {
        //given
        Character character = new Character(10, 15);
        //when
        Movement move1 = character.getMovement();

        character.setMovement(Movement.Left);
        Movement move2 = character.getMovement();


        character.setMovement(Movement.Right);
        Movement move3 = character.getMovement();


        character.setMovement(Movement.None);
        Movement move4 = character.getMovement();

        //then
        assertEquals(Movement.None, move1);
        assertEquals(Movement.Left, move2);
        assertEquals(Movement.Right, move3);
        assertEquals(Movement.None, move4);
    }

    @Test
    void fuel() {
        Character character = new Character(10,15);
        assertEquals(50, character.getFuel());

        character.addFuel(10);
        double fuel1 = character.getFuel();
        character.addFuel(20);
        double fuel2 = character.getFuel();
        character.decreaseFuel();
        double fuel3 = character.getFuel();
        character.decreaseFuel();
        double fuel4 = character.getFuel();
        assertEquals(60, fuel1);
        assertEquals(80, fuel2);
        assertEquals(79.95, fuel3);
        assertEquals(79.90, fuel4);
    }

    @Test
    void hp() {
        Character character = new Character(10, 15);
        assertEquals(20, character.getHP());
        character.loseHP();
        assertEquals(15, character.getHP());
        character.loseHP();
        assertEquals(10, character.getHP());
        character.loseHP();
        character.loseHP();
        character.loseHP();
        assertEquals(0, character.getHP());

    }

    @Test
    void updateGreaterThanMaxVelocity() {
        //given
        Character character = new Character(10, 15);
        character.setVelocity(Character.MAX_VELOCITY + 1);

        //when
        character.setAcelerate(true);
        character.move(50);

        //then
        assertEquals(Character.MAX_VELOCITY, character.getVelocity());
    }
    @Test
    void updateWithVelocity() {
        //given
        Character character = new Character(10, 15);
        character.setVelocity(50);

        //when
        character.setAcelerate(true);
        character.move(50);
        double v1 = character.getVelocity();
        character.move(50);
        double v2 = character.getVelocity();
        character.move(50);
        double v3 = character.getVelocity();
        character.move(50);
        double v4 = character.getVelocity();

        //then
        assertEquals(52, v1);
        assertEquals(54, v2);
        assertEquals(56, v3);
        assertEquals(58, v4);
    }
    @Test
    void updateMAXvelocity() {
        //given
        Character character = new Character(10, 15);
        character.setVelocity(Character.MAX_VELOCITY);

        //when
        character.setAcelerate(true);
        character.move(50);
        //then
        assertEquals(Character.MAX_VELOCITY, character.getVelocity());
    }


}

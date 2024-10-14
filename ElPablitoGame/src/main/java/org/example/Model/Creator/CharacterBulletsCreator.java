package org.example.Model.Creator;

import org.example.Model.Elements.Bullet;
import org.example.Model.Elements.Element;
import org.example.Model.Position;
import org.example.Model.Elements.Character;

import java.util.List;

public class CharacterBulletsCreator extends BulletsCreator{
    private final Character character;

    public CharacterBulletsCreator(Character character, List<Element> elements) {
        super(elements);
        this.character = character;
    }

    @Override
    public Element create() {
        Position bulletPos = nextPos(character.getAngle(), character);
        return new Bullet(bulletPos.getX(), bulletPos.getY(), (float) character.getAngle());
    }
}

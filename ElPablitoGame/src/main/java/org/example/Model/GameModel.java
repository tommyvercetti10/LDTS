package org.example.Model;

import org.example.Controller.SoundManager;
import org.example.Model.Creator.*;
import org.example.Model.Elements.Bullet;
import org.example.Model.Elements.Character;
import org.example.Model.Elements.Element;
import org.example.Model.Elements.Enemies.Enemy;
import org.example.Model.Elements.Items.Cash;
import org.example.Model.Elements.Items.Drugs;
import org.example.Model.Elements.Items.Fuel;
import org.example.Model.Elements.Items.Item;
import org.example.Model.Spawner.Spawner;
import org.example.Viewer.GameViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {
    private final Character character;
    private final List<Element> elements;

    public GameModel(GameViewer gameViewer) {
        this.elements = new ArrayList<>();
        this.character = new Character((double) gameViewer.getWidth() /2, (double) gameViewer.getHeight() /2);
        character.setBulletsCreator(new CharacterBulletsCreator(character, elements));
        elements.add(character);
        Spawner spawner = new Spawner(elements);
        spawner.spawn(new PoliceCarsCreator(new Random()), 2000, 2);
        spawner.spawn(new FuelCreator(new Random()), 30000, 1);
        spawner.spawn(new DrugsCreator(new Random()), 15000, 5);
        spawner.spawn(new CashCreator(new Random()), 23000, 7);
        gameViewer.setGameModel(this);
    }

    public void update(long dt) {
        for (int i = 0; i < elements.size(); i++) elements.get(i).move(dt);
        checkCollisions();
    }

    public void checkCollisions() {
        for (int i = 0; i < getElements().size() - 1; i++) {
            for (int j = i + 1; j < getElements().size(); j++) {
                Element c1 = getElements().get(i);
                Element c2 = getElements().get(j);

                if ((c1 instanceof Enemy && c2 instanceof Enemy))
                    continue;
                if (c1.collide(c2) && c1.getAlive() && c2.getAlive()) {
                    if (c1 instanceof Character && c2 instanceof Enemy) {
                        ((Character) c1).loseHP();
                        c2.setAlive(false);
                        character.increaseXP(6);
                        SoundManager.getInstance().start("crash");
                    }
                    if ((c1 instanceof Bullet && c2 instanceof Enemy) || (c1 instanceof Enemy && c2 instanceof Bullet)) {
                        c1.setAlive(false);
                        c2.setAlive(false);
                        character.increaseXP(10);
                    }
                    if (c1 instanceof Character && c2 instanceof Item) {
                        if (c2 instanceof Fuel) ((Character) c1).addFuel(10);
                        else if (c2 instanceof Drugs) ((Character) c1).addDrugs(10);
                        else if (c2 instanceof Cash) ((Character) c1).addCash(10);
                        c2.setAlive(false);
                        character.increaseXP(3);
                        SoundManager.getInstance().start("caught");
                    }
                }
            }
        }
        elements.removeIf(c -> !c.getAlive());
    }

    //region GETTERS && SETTERS
    public Character getCharacter() { return character;}
    public List<Element> getElements() { return elements;}

    //endregion
}

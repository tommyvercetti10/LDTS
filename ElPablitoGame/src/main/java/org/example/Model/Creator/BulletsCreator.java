package org.example.Model.Creator;

import org.example.Model.Elements.Element;
import org.example.Model.Position;

import java.util.List;

public abstract class BulletsCreator extends Creator{
    private final List<Element> elements;
    private static int bulletWidth = 3;
    private static int bulletHeight = 3;

    public BulletsCreator(List<Element> elements) { this.elements = elements;}

    public void addBullet(Element element) { elements.add(element);}

    public Position nextPos(double angle, Element shooter) {
        Position laserPos = new Position(shooter.getX(), shooter.getY());
        double distance = Math.sqrt(Math.pow(shooter.getWidth() / 2, 2) + Math.pow(shooter.getHeight() / 2, 2));
        double addX = Math.cos(angle)*(distance/2 + bulletWidth+1);
        double addY = Math.sin(angle)*(distance/2 + bulletHeight+1);

        laserPos.setX(laserPos.getX() + addX);
        laserPos.setY(laserPos.getY() + addY);
        return laserPos;
    }

    public List<Element> getElements() {return this.elements;}
}

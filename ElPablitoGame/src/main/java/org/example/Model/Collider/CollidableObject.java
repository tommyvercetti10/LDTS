package org.example.Model.Collider;

import org.example.Model.Elements.Element;

public interface CollidableObject {
    Element getElement();
    default boolean collide(CollidableObject object) {
        Element element1 = getElement();
        Element element2 = object.getElement();
        return element1.getX() < element2.getX() + element2.getWidth() &&
                element1.getX() + element1.getWidth() > element2.getX() &&
                element1.getY() < element2.getY() + element2.getHeight() &&
                element1.getY() + element1.getHeight() > element2.getY();
    }
}

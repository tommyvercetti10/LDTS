package org.example.Model.Elements.Enemies;

import org.example.Controller.Movement;
import org.example.Model.Position;

public class PoliceCar extends Enemy {
    public PoliceCar(double x, double y) {
        super(x, y, 20);
        setMovement(Movement.None);
        this.setAngle(-Math.PI/2);
        this.setVelocity(5);
    }
    @Override
    public void move(long dt) {
        addAngle(getMovement().getValue()*getAngularVelocity()*50/1000);
        double x = getX();
        double y = getY();
        x += getVelocity() * Math.cos(getAngle());
        y += getVelocity() * Math.sin(getAngle());
        if (getAlive()) setPosition(new Position(x, y));
    }
}
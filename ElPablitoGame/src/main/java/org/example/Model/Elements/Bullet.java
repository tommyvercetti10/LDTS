package org.example.Model.Elements;

import org.example.Model.Position;

public class Bullet extends Element {
    private final float angle;
    private double velocity = 300.0;
    private boolean spawned = true;

    public Bullet(double x, double y, float angle) {
        super(x, y);
        this.angle = angle;
    }

    @Override
    public void move(long dt) {
         if (!spawned) {
             double x = getX();
             double y = getY();
             x += velocity * Math.cos(angle) * dt / 1000;
             y += velocity * Math.sin(angle) * dt / 1000;
             Position newPos = new Position(x, y);
             if (checkBoundary(newPos)) setPosition(new Position(x, y));
             else setAlive(false);
         }
         spawned = false;
    }

}


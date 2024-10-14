package org.example.Model.Elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulletTest {
    @Test
    void move() {
        double velocityBullet = 300.0;
        float angle = 0;
        long dt = 50;
        double x = 10;
        double y = 10;
        Bullet bullet = new Bullet(x, y, angle);

        bullet.move(dt);
        bullet.move(dt);
        assertEquals(x + (velocityBullet * Math.cos(angle) * dt / 1000), bullet.getX());
        assertEquals(y + (velocityBullet * Math.sin(angle) * dt / 1000), bullet.getY());
    }
}

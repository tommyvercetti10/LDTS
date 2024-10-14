package org.example.Model.Elements;

import org.example.Controller.Movement;
import org.example.Model.Creator.BulletsCreator;
import org.example.Model.Position;

public class Character extends Element {
    private int hp, xp = 0;
    private int drugs=0, cash=0;
    private double fuel = 50.0;
    private double angle, velocity;
    private final double angularVelocity = Math.PI * 1.5;
    public static double MAX_VELOCITY = 100.0;
    private boolean acelarate;
    private Movement movement;
    private boolean shoot;
    private BulletsCreator bulletsCreator;
    private boolean wasHit = false;

    public Character(double x, double y) {
        super(x, y);
        setMovement(Movement.None);
        this.hp = 20;
        this.angle = -Math.PI/2;
        this.velocity = 0;
        this.bulletsCreator = null;
    }

    @Override
    public void move(long dt){
        angle += movement.getValue()*angularVelocity*dt/1000;

        if(isAccelerating()) {
            if(velocity >= MAX_VELOCITY) {
                velocity = MAX_VELOCITY;
            }
            else if(velocity < MAX_VELOCITY) {
                velocity += 2;
            }
            double x = getX();
            double y = getY();
            x += velocity * dt / 1000 * Math.cos(angle);
            y += velocity * dt / 1000 * Math.sin(angle);
            Position newPos = new Position(x, y);
            if (checkBoundary(newPos) && hp != 0 && fuel != 0.0)
            {
                setPosition(newPos);
                decreaseFuel();
            }
        }else {
            if(velocity <= 0) {
                velocity = 0;
            }
            else {
                velocity *= 0.50;
            }
        }
        if (shoot) {
            bulletsCreator.addBullet(bulletsCreator.create());
            shoot = false;
        }
    }

    //region GETTERS && SETTERS
    public int getHP(){return hp;}
    public void loseHP(){
        if (hp - 5 > 0) {
            hp -= 5;
            wasHit = true;
        }
        else
        {
            hp = 0;
            System.out.println("WASTED!!! Pablito was killed");
        }
    }
    public int getXP() { return xp;}
    public void increaseXP(int xp) { this.xp += xp;}
    public int getDrugs(){return drugs;}
    public void addDrugs(int drugs){
        this.drugs+=drugs;
    }
    public int getCash(){return cash;}
    public void addCash(int cash){
        this.cash+=cash;
    }
    public double getFuel(){return fuel;}
    public void addFuel(int fuel){
        this.fuel+=fuel;
    }
    public void decreaseFuel() {
        if (fuel - 0.05 > 0) fuel -= 0.05;
        else
        {
            fuel = 0;
            System.out.println("FUEL MISSING!!! Pablito can't move");
        }
    }
    public double getAngle() {
        return this.angle;
    }
    public Movement getMovement() {return this.movement;}
    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    public boolean isAccelerating() {
        return this.acelarate;
    }
    public void setAcelerate(boolean acelarate) {
        this.acelarate = acelarate;
    }
    public void setShoot(boolean shoot) { this.shoot = shoot;  }
    public boolean getShoot() {return this.shoot;}
    public void setBulletsCreator(BulletsCreator bulletsCreator) { this.bulletsCreator = bulletsCreator; }
    public boolean getWasHit() { return wasHit; }
    public void setWasHit(boolean wasHit) { this.wasHit = wasHit;}
    public void setVelocity(double velocity) {this.velocity = velocity;}
    public double getVelocity() {return this.velocity;}
    //endregion
}
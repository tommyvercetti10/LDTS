package org.example.Model.Elements.Enemies;

import org.example.Controller.Movement;
import org.example.Model.Elements.Element;

public class Enemy extends Element {
    private double angle;
    private final double angularVelocity = Math.PI * 1.5;
    private double velocity=30;
    private Movement movement;

    public Enemy(double x, double y, int hp) {
        super(x, y);
    }

    //region GETTERS && SETTERS
    public  double getAngle() {
        return this.angle;
    }
    public void setAngle(double angle){ this.angle = angle;}
    public void addAngle(double angle){ this.angle += angle;}
    public double getAngularVelocity() { return this.angularVelocity;}
    public double getVelocity(){ return this.velocity;}
    public void setVelocity(double velocity){this.velocity = velocity; }
    public Movement getMovement() {return this.movement;}
    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    //endregion
}
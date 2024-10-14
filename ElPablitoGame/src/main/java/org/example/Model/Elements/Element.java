package org.example.Model.Elements;

import org.example.Screen;
import org.example.Model.Collider.CollidableObject;
import org.example.Model.Position;

public abstract class Element implements CollidableObject {
    private Position position;
    private double width;
    private double height;
    private boolean alive = true;

    public Element(double x, double y){
        this.position = new Position(x,y);
    }

    public void move(long dt) {}

    public boolean checkBoundary(Position pos) {
        return !(pos.getX() <= 5) && !(pos.getX() >= Screen.WIDTH - 5) && !(pos.getY() <= 5) && !(pos.getY() >= Screen.HEIGHT - 5);
    }

    @Override
    public Element getElement() {
        return this;
    }

    //region GETTERS && SETTERS
    public Position getPosition(){
        return position;
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public double getX(){ return position.getX();}
    public double getY(){return position.getY();}
    public double getWidth() { return width;}
    public void setWidth(double width) { this.width = width; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    public boolean getAlive() { return alive;}
    public void setAlive(boolean alive) { this.alive = alive;}
    //endregion
}

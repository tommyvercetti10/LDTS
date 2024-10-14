package org.example.Model;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public Position clone(){
        return new Position(x,y);
    }
    //region GETTERS && SETTERS
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    //endregion


}

package org.example.Model;

import org.example.Model.Elements.Element;

import static java.lang.Math.signum;

public class RotationPoint extends Element {
    public RotationPoint(double x, double y) {
        super(x, y);
    }

    public double CalculateProduct(RotationPoint point) { return point.getX()* getX() + point.getY()* getY(); }
    public double module() {return Math.sqrt(getX()* getX() + getY()* getY()); }
    public RotationPoint rotationPoint(double angle){
        double pointAngle = Math.acos(CalculateProduct(new RotationPoint(1,0))/module());
        if(signum(getY()) == -1)
            pointAngle = Math.PI*2 - pointAngle;


        double distance = module();
        double newX = Math.cos(angle + pointAngle)* distance;
        double newY = Math.sin(angle + pointAngle)* distance;
        return new RotationPoint(newX, newY);
    }


}

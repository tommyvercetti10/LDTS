package org.example.Model.Creator;

import org.example.Screen;
import org.example.Model.Elements.Element;
import org.example.Model.Elements.Enemies.PoliceCar;

import java.util.Random;

public class PoliceCarsCreator extends Creator{
    private final Random random;
    private int counter = 0;
    public PoliceCarsCreator(Random random) { this.random = random; }
    @Override
    public Element create() {
        if (counter == 2) counter = 0;
        int y= random.nextInt(Screen.HEIGHT) + (counter == 0? 50 : 360);
        PoliceCar policeCar = new PoliceCar(counter == 0? 0 : Screen.WIDTH,y);
        policeCar.setAngle(counter == 0? 0 : 180);
        counter++;
        return policeCar;
    }
}

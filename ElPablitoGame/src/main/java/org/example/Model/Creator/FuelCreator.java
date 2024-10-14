package org.example.Model.Creator;

import org.example.Model.Elements.Element;
import org.example.Model.Elements.Items.Fuel;

import java.util.Random;

public class FuelCreator extends Creator {
    private final Random random;
    public FuelCreator(Random random) { this.random = random; }
    @Override
    public Element create() {
        int x = random.nextInt( 399);
        int y = random.nextInt(30, 399);
        int q = random.nextInt(10);
        return new Fuel(x, y, q);
    }
}

package org.example.Model.Creator;

import org.example.Model.Elements.Items.Drugs;
import org.example.Model.Elements.Element;

import java.util.Random;

public class DrugsCreator extends Creator {
    private final Random random;
    public DrugsCreator(Random random) { this.random = random; }
    @Override
    public Element create() {
        int x = random.nextInt( 399);
        int y = random.nextInt(30, 399);
        int q = random.nextInt(10);
        return new Drugs(x, y, q);
    }
}

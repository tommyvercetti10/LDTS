package org.example.Model.Creator;

import org.example.Model.Elements.Items.Cash;
import org.example.Model.Elements.Element;

import java.util.Random;

public class CashCreator extends Creator {
    private final Random random;
    public CashCreator(Random random) { this.random = random; }
    @Override
    public Element create() {
        int x = random.nextInt( 399);
        int y = random.nextInt(30, 399);
        int q = random.nextInt(10);
        return new Cash(x, y, q);
    }
}

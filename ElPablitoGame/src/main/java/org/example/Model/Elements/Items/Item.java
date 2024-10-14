package org.example.Model.Elements.Items;

import org.example.Model.Elements.Element;

public class Item extends Element {
    private int quantity;
    public Item(double x, double y) {
        super(x, y);
    }

    //region GETTERS && SETTERS
    public int getQuantity() { return this.quantity;}
    public void setQuantity(int quantity) { this.quantity = quantity;}
    //endregion
}

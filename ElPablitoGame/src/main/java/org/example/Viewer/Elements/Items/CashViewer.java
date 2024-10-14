package org.example.Viewer.Elements.Items;

import org.example.Image;
import org.example.Model.Elements.Items.Cash;

import java.io.IOException;

public class CashViewer extends ItemViewer {
    public CashViewer(Cash cash) throws IOException {
        setItem(cash);
        setImage(new Image().loadString("src/resources/images/moneyBag.png"));
    }
}


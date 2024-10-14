package org.example.Viewer.Elements.Items;

import org.example.Image;
import org.example.Model.Elements.Items.Fuel;

import java.io.IOException;

public class FuelViewer extends ItemViewer {
    public FuelViewer(Fuel fuel) throws IOException {
        setItem(fuel);
        setImage(new Image().loadString("src/resources/images/gasolineIcon.png"));
    }
}

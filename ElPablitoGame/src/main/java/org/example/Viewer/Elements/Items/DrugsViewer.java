package org.example.Viewer.Elements.Items;

import org.example.Image;
import org.example.Model.Elements.Items.Drugs;

import java.io.IOException;

public class DrugsViewer extends ItemViewer {
    public DrugsViewer(Drugs drug) throws IOException {
        setItem(drug);
        setImage(new Image().loadString("src/resources/images/drug.png"));
    }
}

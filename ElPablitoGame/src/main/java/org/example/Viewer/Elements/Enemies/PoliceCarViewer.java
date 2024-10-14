package org.example.Viewer.Elements.Enemies;

import org.example.Image;
import org.example.Model.Elements.Enemies.PoliceCar;
import org.example.Viewer.Elements.Enemies.EnemyViewer;

import java.io.IOException;

public class PoliceCarViewer extends EnemyViewer {
    public PoliceCarViewer(PoliceCar policeCar) throws IOException {
        setEnemy(policeCar);
        setImage(new Image().loadString("data/images/policeCar.png"));
    }
}
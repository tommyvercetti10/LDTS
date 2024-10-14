package org.example.Viewer.Elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Model.Elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(TextGraphics graphics);
    void drawElement(String[] draw, double angle, TextGraphics graphics, double posX, double posY);
}

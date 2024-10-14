package org.example.Viewer.Elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Model.Elements.Bullet;

import java.io.IOException;

public class BulletViewer implements ElementViewer<Bullet> {
    private final Bullet bullet;
    private static final int charWidth = 1;
    private static final int charHeight = 1;
    private String[] image;

    public BulletViewer(Bullet bullet) throws IOException {
        this.bullet = bullet;
        this.image = new Image().loadString("src/resources/images/bullet.png");
    }

    @Override
    public void draw(TextGraphics graphics) {
        int x = (int) bullet.getPosition().getX();
        int y = (int) bullet.getPosition().getY();
        bullet.setWidth(image.length * 4);
        bullet.setHeight(image.length * 4);
        drawElement(image, 0, graphics, x, y);
    }

    @Override
    public void drawElement(String[] draw, double angle, TextGraphics graphics, double posX, double posY) {
        for(int y = 0; y < image.length; y++){
            String[] c = image[y].split("-");
            for(int x = 0; x < image.length; x++){
                if(!c[x].equals("*")){
                    graphics.setBackgroundColor(TextColor.Factory.fromString(c[x]));
                    graphics.fillRectangle(new TerminalPosition((int) posX + x, (int) posY + y),
                            new TerminalSize(charWidth, charHeight), ' ');
                }
            }
        }
    }
}

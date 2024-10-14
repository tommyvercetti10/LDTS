package org.example.Viewer.Elements;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Model.Elements.Character;
import org.example.Model.RotationPoint;

import java.io.IOException;

import static java.lang.Math.signum;

public class CharacterViewer implements ElementViewer<Character> {

    private Character character;
    private String[] image;
    private static final int charWidth = 1;
    private static final int charHeight = 1;

    public CharacterViewer(Character character) throws IOException {
        this.character = character;
        this.image = new Image().loadString("src/resources/images/characterCar.png");
    }

    @Override
    public void draw(TextGraphics graphics) {
        int x = (int) character.getPosition().getX();
        int y = (int) character.getPosition().getY();
        double angle = character.getAngle() + Math.PI/2.0;
        character.setWidth(image.length);
        character.setHeight(image.length);
        if (character.getWasHit()) drawColor("#FFFFFF", angle, graphics, x, y);
        else if (character.getHP() != 0) drawElement(image, angle, graphics,x, y);
        else drawColor("#FF0000", angle, graphics, x, y);
    }

    @Override
    public void drawElement(String[] draw, double angle, TextGraphics graphics, double posX, double posY){
        double mid = (double) image.length / 2;
        for(int y = 0; y < image.length; y++){
            String[] c = image[y].split("-");
            for(int x = 0; x < image.length; x++){
                if(!c[x].equals("*")){
                    RotationPoint point = new RotationPoint(x- mid, y - mid);
                    RotationPoint newPoint = point.rotationPoint(angle);
                    graphics.setBackgroundColor(TextColor.Factory.fromString(c[x]));
                    graphics.fillRectangle(new TerminalPosition((int) (posX + (newPoint.getX() * charWidth)), (int)(posY + (newPoint.getY() * charHeight))),
                            new TerminalSize(charWidth, charHeight), ' ');
                }
            }
        }
    }

    public void drawColor(String color, double angle, TextGraphics graphics, double posX, double posY) {
        double midX = (double) image.length / 2;
        double midY = (double) image.length / 2;
        for(int y = 0; y < image.length; y++){
            String[] c = image[y].split("-");
            for(int x = 0; x < image.length; x++){
                if(!c[x].equals("*")){
                    RotationPoint point = new RotationPoint(x- midX, y - midY);
                    RotationPoint newPoint = point.rotationPoint(angle);
                    graphics.setBackgroundColor(TextColor.Factory.fromString(color));
                    graphics.fillRectangle(new TerminalPosition((int) (posX + (newPoint.getX() * charWidth)), (int)(posY + (newPoint.getY() * charHeight))),
                            new TerminalSize(charWidth, charHeight), ' ');
                }
            }
        }
        character.setWasHit(false);
    }
}

package org.example.Viewer.Elements.Enemies;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Model.Elements.Enemies.Enemy;
import org.example.Model.RotationPoint;
import org.example.Viewer.Elements.ElementViewer;

public class EnemyViewer implements ElementViewer<Enemy> {
    private Enemy enemy;
    private String[] image;
    private static final int CHAR_WIDTH = 1;
    private static final int CHAR_HEIGHT = 1;
    @Override
    public void draw(TextGraphics graphics) {
        int x = (int) enemy.getPosition().getX();
        int y = (int) enemy.getPosition().getY();
        double angle = enemy.getAngle() + Math.PI/2.0;
        drawElement(image, angle, graphics,x, y);
    }

    @Override
    public void drawElement(String[] draw, double angle, TextGraphics graphics, double posX, double posY) {
        double midX = (double) draw.length/2;
        double midY = (double) draw.length/2;
        for(int y = 0; y < draw.length; y++){
            String[] c = draw[y].split("-");
            for(int x = 0; x < draw.length; x++){
                if(!c[x].equals("*")){
                    RotationPoint point = new RotationPoint(x- midX, y - midY);
                    RotationPoint newPoint = point.rotationPoint(angle);

                    graphics.setBackgroundColor(TextColor.Factory.fromString(c[x]));
                    graphics.fillRectangle(new TerminalPosition((int) (posX + (newPoint.getX() * CHAR_WIDTH)), (int)(posY + (newPoint.getY() * CHAR_HEIGHT))),
                            new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                }
            }
        }
    }

    //region GETTERS && SETTERS
    public Enemy getEnemy() { return enemy; }
    public void setEnemy(Enemy enemy) { this.enemy = enemy; }
    public String[] getImage() { return image;}
    public void setImage(String[] image) { this.image = image; }
    //endregion
}

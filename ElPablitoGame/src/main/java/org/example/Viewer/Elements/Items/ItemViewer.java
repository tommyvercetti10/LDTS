package org.example.Viewer.Elements.Items;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Model.Elements.Items.Item;
import org.example.Viewer.Elements.ElementViewer;

public class ItemViewer implements ElementViewer<Item> {
    private Item item;
    private static final int charWidth = 1;
    private static final int charHeight = 1;
    private String[] image;
    @Override
    public void draw(TextGraphics graphics) {
        int x = (int) item.getPosition().getX();
        int y = (int) item.getPosition().getY();
        item.setWidth(image.length);
        item.setHeight(image.length);
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

    //region GETTERS && SETTERS
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
    public String[] getImage() { return image;}
    public void setImage(String[] image) { this.image = image; }
    //endregion
}

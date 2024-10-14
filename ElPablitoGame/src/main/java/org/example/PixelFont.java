package org.example;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Model.Position;
import org.example.Viewer.ScreenView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class PixelFont {
    private ScreenView screenView;
    private ArrayList<Tile> numbers = new ArrayList<>();
    private ArrayList<Tile> letters = new ArrayList<>();

    public PixelFont(ScreenView screenView) throws IOException {
        this.screenView = screenView;
        readTileSet("src/resources/fonts/numbers.png", numbers, 3, 6);
        readTileSet("src/resources/fonts/letters.png", letters, 5, 6);
    }

    public void readTileSet(String filePath, ArrayList<Tile> tiles, int tileWidth, int tileHeight) throws IOException {
        int t = 0;
        BufferedImage tileSet = ImageIO.read(new File(filePath));
        for (int y = 0; y < tileSet.getHeight() / tileHeight; y++) {
            for (int x = 0; x < tileSet.getWidth() / tileWidth; x++) {
                BufferedImage tile = tileSet.getSubimage(
                        x * tileWidth, y * tileHeight, tileWidth, tileHeight);
                tiles.add(new Tile());
                tiles.get(t).setImage(new Image().loadString(tile));
                t++;
            }
        }
    }

    public void drawNumber(String number, Position position, double spacing, String color, int size) {
        int count = 0;
        while (count != number.length()) {
            drawElement(numbers.get(Character.getNumericValue(number.charAt(count))).getImage(), screenView.getGraphics(),
                    position.getX() + (spacing * count), position.getY(), 3, color, size);
            count++;
        }
    }

    public void drawText(String text, Position position, double spacing, String color, int size) {
        int count = 0;
        while (count != text.length()) {
            drawElement(letters.get((int)text.charAt(count) - 65).getImage(), screenView.getGraphics(),
                    position.getX() + (spacing * count), position.getY(), 5, color, size);
            count++;
        }
    }

    public void drawElement(String[] image, TextGraphics graphics, double posX, double posY, int tileWidth, String color, int size){
        for(int y = 0; y < image.length; y++){
            String[] c = image[y].split("-");
            for(int x = 0; x < tileWidth; x++){
                if(!c[x].equals("*")){
                    graphics.setBackgroundColor(TextColor.Factory.fromString(color));
                    graphics.fillRectangle(new TerminalPosition((int)posX + (x * size), (int)posY + (y * size)),
                            new TerminalSize(size, size), ' ');
                }
            }
        }
    }

}

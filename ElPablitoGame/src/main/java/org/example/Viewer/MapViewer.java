package org.example.Viewer;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Image;
import org.example.Model.Map;
import org.example.Tile;
import org.example.Viewer.Elements.ElementViewer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MapViewer implements ElementViewer<Map> {
    private GameViewer gameViewer;
    private ArrayList<Tile> tiles = new ArrayList<>();
    private int mapTileNum[][];
    private static final int CHAR_WIDTH = 1;
    private static final int CHAR_HEIGHT = 1;

    public MapViewer(GameViewer gameViewer) throws IOException {
        this.gameViewer = gameViewer;
        readTileSet("src/resources/images/tileSet1.png");
        mapTileNum = new int[gameViewer.getMaxCol()][gameViewer.getMaxRow()];
        loadMap("src/resources/maps/map.txt");}

    public void readTileSet(String filePath) throws IOException {
        int t = 0;
        BufferedImage tileSet = ImageIO.read(new File(filePath));
        for (int y = 0; y < tileSet.getHeight() / gameViewer.getTileSize(); y++) {
            for (int x = 0; x < tileSet.getWidth() / gameViewer.getTileSize(); x++) {
                BufferedImage tile = tileSet.getSubimage(
                        x * gameViewer.getTileSize(), y * gameViewer.getTileSize(), gameViewer.getTileSize(), gameViewer.getTileSize());
                tiles.add(new Tile());
                tiles.get(t).setImage(new Image().loadString(tile));
                t++;
            }
        }
    }

    public void loadMap(String filePath) throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath), UTF_8);
        int col = 0, row = 0;
        while(col < gameViewer.getMaxCol() && row < gameViewer.getMaxRow()) {
            String line = bufferedReader.readLine();
            while (col < gameViewer.getMaxCol()) {
                String numbers[] = line.split(" ");
                int num = Integer.parseInt(numbers[col]);
                mapTileNum[col][row] = num;
                col++;
            }
            if (col == gameViewer.getMaxCol()) {
                col = 0;
                row++;
            }
        }
        bufferedReader.close();
    }
    @Override
    public void draw(TextGraphics graphics) {
        int col = 0, row = 0;
        int x = 0, y = 0;
        while (col < gameViewer.getMaxCol() && row < gameViewer.getMaxRow()) {
            int tileNum = mapTileNum[col][row];
            drawElement(tiles.get(tileNum).getImage(), 0, graphics, x, y);
            col++;
            x += gameViewer.getTileSize();
            if (col == gameViewer.getMaxCol()) {
                col = 0;
                row++;
                x = 0;
                y += gameViewer.getTileSize();
            }
        }
    }

    @Override
    public void drawElement(String[] image, double angle, TextGraphics graphics, double posX, double posY){
        for(int y = 0; y < image.length; y++){
            String[] c = image[y].split("-");
            for(int x = 0; x < image.length; x++){
                if(!c[x].equals("*")){
                    graphics.setBackgroundColor(TextColor.Factory.fromString(c[x]));
                    graphics.fillRectangle(new TerminalPosition((int)posX + (x * CHAR_WIDTH), (int)posY + (y * CHAR_HEIGHT)),
                            new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                }
            }
        }
    }

}

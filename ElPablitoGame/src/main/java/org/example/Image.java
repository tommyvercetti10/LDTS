package org.example;

import com.googlecode.lanterna.terminal.swing.TerminalScrollController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class Image {
    public String[] loadString(Object input) throws IOException {
        BufferedImage image = null;
        if (input instanceof String) image = ImageIO.read(new File((String) input));
        else if (input instanceof BufferedImage) image = (BufferedImage) input;
        else System.out.println("Unsupported input type");

        if (image != null) {
            return convertImageToText(image);
        } else {
            System.out.println("Image loading failed!");
        }
        return null;
    }

    private String[] convertImageToText(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        String[] newImage = new String[height];
        Arrays.fill(newImage, "");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                String hexCode = getHexCode(rgb);
                newImage[y] = newImage[y] + hexCode;
                if (x != width - 1) newImage[y] += "-";
            }
            //System.out.println(newImage[y]);
        }
        return newImage;
    }

    private static String getHexCode(int rgb) {
        Color color = new Color(rgb);
        if (color.getRed() == 126 && color.getGreen() == 121 && color.getBlue() == 255) return "*";
        else return String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    }
}

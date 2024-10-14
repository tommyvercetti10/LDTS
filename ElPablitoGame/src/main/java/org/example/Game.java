package org.example;

import org.example.Controller.Controller;
import org.example.Viewer.*;

import java.awt.*;

import java.io.IOException;
import java.net.URISyntaxException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game {
    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.run();
    }
}
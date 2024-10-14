package org.example.Viewer;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;

public abstract class ScreenView {
    private TextGraphics graphics;
    private TerminalScreen screen;

    public Terminal createTerminal(int width, int height) throws IOException {
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true,
                AWTTerminalFontConfiguration.BoldMode.NOTHING, new Font(Font.MONOSPACED,Font.PLAIN, 1));
        Terminal terminal = new DefaultTerminalFactory()
                .setForceAWTOverSwing(true)
                .setInitialTerminalSize(new TerminalSize(width, height))
                .setTerminalEmulatorFontConfiguration(cfg)
                .createTerminal();
        return terminal;
    }

    public TerminalScreen createScreen(Terminal terminal) throws IOException {
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    public abstract void draw() throws IOException;

    public void addKeyListener(KeyListener keyListener) {
        ((AWTTerminalFrame)screen.getTerminal()).getComponent(0).addKeyListener(keyListener);
    }

    public TextGraphics getGraphics() { return graphics;}
    public void setGraphics(TextGraphics graphics) { this.graphics = graphics;}
    public TerminalScreen getScreen() { return screen;}
    public void setScreen(TerminalScreen screen) { this.screen = screen;}
}

package org.example.States;

import org.example.Controller.Controller;
import org.example.Model.Elements.Character;
import org.example.Model.Menus.MainMenu;
import org.example.Viewer.MenuViewer;
import org.example.Viewer.ScreenView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MenuController implements StateController, KeyListener {
    private final Controller context;
    private final ScreenView menuViewer;
    private final MainMenu mainMenu;
    private Character character = new Character(0,0);


    public MenuController(Controller context) throws IOException {
        this.context = context;
        this.mainMenu = new MainMenu();
        this.menuViewer = new MenuViewer(mainMenu);
    }

    @Override
    public void run() throws IOException {
        menuViewer.addKeyListener(this);

        while (context.getApplicationState() == ApplicationState.MainMenu) {
            menuViewer.draw();

            if(mainMenu.wasChosen())
                nextState();
        }
        menuViewer.getScreen().close();
    }

    @Override
    public void nextState() throws IOException {
        switch (mainMenu.getSelected()){
            case "PLAY":
                context.updateState(ApplicationState.Game, character);
                break;
            case "EXIT":
                context.updateState(ApplicationState.Exit, character);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN, KeyEvent.VK_UP:
                mainMenu.select();
                break;
            case KeyEvent.VK_ENTER:
                mainMenu.setChosen(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public MainMenu getMenu() {return this.mainMenu;}
    public ScreenView getMenuViewer() {return this.menuViewer;}
}

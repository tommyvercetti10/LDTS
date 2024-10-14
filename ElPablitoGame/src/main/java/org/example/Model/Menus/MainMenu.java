package org.example.Model.Menus;

public class MainMenu extends Menu {
    public MainMenu() {
        setOptions(new String[]{"PLAY", "EXIT"});
        setSelected(getOptions()[0]);
        setChosen(false);
    }
}

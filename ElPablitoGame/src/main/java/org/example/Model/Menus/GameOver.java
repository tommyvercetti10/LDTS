package org.example.Model.Menus;

public class GameOver extends Menu {
    public GameOver() {
        setOptions(new String[]{"RESTART", "EXIT"});
        setSelected(getOptions()[0]);
        setChosen(false);
    }
}

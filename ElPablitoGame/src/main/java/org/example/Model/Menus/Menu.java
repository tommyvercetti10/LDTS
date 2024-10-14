package org.example.Model.Menus;

public abstract class Menu {
    private String[] options;
    private String selected;
    private boolean chosen;

    public void select(){
        if(!chosen) {
            if (selected.equals(options[0])) selected = options[1];
            else if (selected.equals(options[1])) selected = options[0];
        }
    }

    //region GETTERS && SETTERS
    public void setOptions(String[] options) { this.options = options;}
    public String[] getOptions() { return this.options; }
    public String getSelected() {
        return selected;
    }
    public void setSelected(String selected) { this.selected = selected;}
    public boolean wasChosen() {
        return chosen;
    }
    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
    //endregion

}

package org.example;

public class Tile {
    private String[] image;
    public boolean collision = false;

    //region GETTERS && SETTERS
    public void setImage(String[] image) { this.image = image; }

    public String[] getImage() { return this.image; }
    //endregion
}

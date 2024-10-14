package org.example.Controller;

public enum Movement {
    Left(-1),
    Right(1),
    None(0);

    private final int value;

    Movement(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

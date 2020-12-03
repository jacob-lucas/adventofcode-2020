package com.jacoblucas.adventofcode2020.day3;

public enum Direction {
    UP(-1),
    DOWN(1),
    LEFT(-1),
    RIGHT(1);

    private final int delta;

    Direction(int delta) {
        this.delta = delta;
    }

    public int getDelta() {
        return delta;
    }
}

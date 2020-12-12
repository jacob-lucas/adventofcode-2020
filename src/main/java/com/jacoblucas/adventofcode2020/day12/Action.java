package com.jacoblucas.adventofcode2020.day12;

import java.util.Arrays;

public enum Action {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W'),
    LEFT('L'),
    RIGHT('R'),
    FORWARD('F');

    final char ch;

    Action(char ch) {
        this.ch = ch;
    }

    public Action getLeft() {
        if (this == NORTH) {
            return WEST;
        } else if (this == SOUTH) {
            return EAST;
        } else if (this == WEST) {
            return SOUTH;
        } else if (this == EAST) {
            return NORTH;
        } else {
            return null;
        }
    }

    public Action getRight() {
        if (this == NORTH) {
            return EAST;
        } else if (this == SOUTH) {
            return WEST;
        } else if (this == WEST) {
            return NORTH;
        } else if (this == EAST) {
            return SOUTH;
        } else {
            return null;
        }
    }

    public static Action of(final char ch) {
        return Arrays.stream(values())
                .filter(a -> a.ch == ch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid action: " + ch));
    }
}

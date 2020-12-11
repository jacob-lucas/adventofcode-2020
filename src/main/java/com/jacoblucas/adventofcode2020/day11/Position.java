package com.jacoblucas.adventofcode2020.day11;

import java.util.Arrays;

public enum Position {
    FLOOR("."),
    EMPTY("L"),
    OCCUPIED("#");

    String value;

    Position(String value) {
        this.value = value;
    }

    static Position of(final String value) {
        return Arrays.stream(values())
                .filter(p -> p.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid position: " + value));
    }
}

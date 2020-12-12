package com.jacoblucas.adventofcode2020.utils;

import java.util.Collection;

public final class Calculator {
    private Calculator() {}

    public static int intProduct(final Collection<Integer> input) {
        return input.isEmpty() ? 0 : input.stream().reduce(1, (a, b) -> a * b);
    }

    public static long longProduct(final Collection<Long> input) {
        return input.isEmpty() ? 0 : input.stream().reduce(1L, (a, b) -> a * b);
    }

    public static int manhattanDistance(final int x1, final int y1, final int x2, final int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

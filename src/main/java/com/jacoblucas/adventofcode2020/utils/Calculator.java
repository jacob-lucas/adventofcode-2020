package com.jacoblucas.adventofcode2020.utils;

import java.util.Set;

public final class Calculator {
    private Calculator() {}

    public static int product(final Set<Integer> input) {
        return input.isEmpty() ? 0 : input.stream().reduce(1, (a, b) -> a * b);
    }
}

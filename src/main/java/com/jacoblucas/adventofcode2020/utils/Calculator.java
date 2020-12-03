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
}

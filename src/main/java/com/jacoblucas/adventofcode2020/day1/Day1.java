package com.jacoblucas.adventofcode2020.day1;

import com.google.common.collect.ImmutableSet;
import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
    public static final int TOTAL = 2020;

    public static void main(String[] args) throws IOException {
        final Set<Integer> expenses = InputReader.read("day1-input.txt").stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        final Set<Integer> twoEntries = findTwo(TOTAL, expenses);
        if (twoEntries.size() != 2) {
            throw new IllegalArgumentException("No expenses sum to expected result");
        }
        System.out.println("Sum of " + twoEntries + " = " + TOTAL);
        final int result1 = product(twoEntries);
        System.out.println(result1);

        final Set<Integer> threeEntries = findThree(TOTAL, expenses);
        if (threeEntries.size() != 3) {
            throw new IllegalArgumentException("No expenses sum to expected result");
        }
        System.out.println("Sum of " + threeEntries + " = " + TOTAL);
        final int result2 = product(threeEntries);
        System.out.println(result2);
    }

    static Set<Integer> findTwo(final int result, final Set<Integer> input) {
        for (int i : input) {
            int diff = result - i;
            if (input.contains(diff)) {
                return ImmutableSet.of(i, diff);
            }
        }
        return ImmutableSet.of();
    }

    static Set<Integer> findThree(final int result, final Set<Integer> input) {
        for (int i : input) {
            int diff = result - i;
            final Set<Integer> subInput = input.stream()
                    .filter(n -> n != diff)
                    .collect(Collectors.toSet());
            final Set<Integer> others = findTwo(diff, subInput);
            if (!others.isEmpty()) {
                return Stream.concat(ImmutableSet.of(i).stream(), others.stream()).collect(Collectors.toSet());
            }
        }
        return ImmutableSet.of();
    }

    static int product(final Set<Integer> input) {
        return input.stream().reduce(1, (a, b) -> a * b);
    }
}

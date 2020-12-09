package com.jacoblucas.adventofcode2020.day1;

import com.google.common.collect.ImmutableSet;
import com.jacoblucas.adventofcode2020.utils.Calculator;
import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
    public static final int TOTAL = 2020;

    public static void main(String[] args) throws IOException {
        final Set<Long> expenses = InputReader.read("day1-input.txt").stream()
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toSet());

        final Set<Long> twoEntries = findTwo(TOTAL, expenses);
        if (twoEntries.size() != 2) {
            throw new IllegalArgumentException("No expenses sum to expected result");
        }
        System.out.println("Sum of " + twoEntries + " = " + TOTAL);
        final long result1 = Calculator.longProduct(twoEntries);
        System.out.println(result1);

        final Set<Long> threeEntries = findThree(TOTAL, expenses);
        if (threeEntries.size() != 3) {
            throw new IllegalArgumentException("No expenses sum to expected result");
        }
        System.out.println("Sum of " + threeEntries + " = " + TOTAL);
        final long result2 = Calculator.longProduct(threeEntries);
        System.out.println(result2);
    }

    public static Set<Long> findTwo(final long result, final Set<Long> input) {
        for (long i : input) {
            long diff = result - i;
            if (input.contains(diff)) {
                return ImmutableSet.of(i, diff);
            }
        }
        return ImmutableSet.of();
    }

    static Set<Long> findThree(final long result, final Set<Long> input) {
        for (long i : input) {
            long diff = result - i;
            final Set<Long> subInput = input.stream()
                    .filter(n -> n != diff)
                    .collect(Collectors.toSet());
            final Set<Long> others = findTwo(diff, subInput);
            if (!others.isEmpty()) {
                return Stream.concat(ImmutableSet.of(i).stream(), others.stream()).collect(Collectors.toSet());
            }
        }
        return ImmutableSet.of();
    }
}

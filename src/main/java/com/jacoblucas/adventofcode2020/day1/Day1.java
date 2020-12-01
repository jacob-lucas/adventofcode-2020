package com.jacoblucas.adventofcode2020.day1;

import com.google.common.collect.ImmutableSet;
import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) throws IOException {
        final Set<Integer> expenses = InputReader.read("day1-input.txt").stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        final Set<Integer> entries = sumTo(2020, expenses);
        if (entries.size() != 2) {
            throw new IllegalArgumentException("No expenses sum to expected result");
        }

        final Iterator<Integer> iterator = entries.iterator();
        final int one = iterator.next();
        final int two = iterator.next();
        final int result = one * two;
        System.out.println(result);
    }

    static Set<Integer> sumTo(final int result, final Set<Integer> input) {
        for (int i : input) {
            int diff = result - i;
            if (input.contains(diff)) {
                System.out.println(i + " + " + diff + " = " + result);
                return ImmutableSet.of(i, diff);
            }
        }
        return ImmutableSet.of();
    }
}

package com.jacoblucas.adventofcode2020.day9;

import com.google.common.collect.ImmutableSet;
import com.jacoblucas.adventofcode2020.day1.Day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XMAS {

    private final int preambleSize;

    public XMAS(final int preambleSize) {
        this.preambleSize = preambleSize;
    }

    // Return index in input list of first invalid entry, -1 if none found
    public int findFirstInvalid(final List<Long> input) {
        if (input.size() < preambleSize) {
            throw new IllegalArgumentException("input size < preamble size");
        }

        int lower = 0;
        int upper = preambleSize;
        int pos = preambleSize;
        List<Long> preamble;

        while (pos < input.size()) {
            preamble = input.subList(lower, upper);

            // check that n is summed to by any of two different numbers in preamble
            final long n = input.get(pos);
            final Set<Long> ints = Day1.findTwo(n, new HashSet<>(preamble));
            if (ints.isEmpty()) {
                return pos;
            }

            lower++;
            upper++;
            pos++;
        }

        return -1;
    }

    public Set<Long> findWeakness(final long invalidNumber, final List<Long> input, final int minSetSize) {
        for (int i = 0; i < input.size(); i++) {
            long sum = 0;
            for (int j = i; j < input.size(); j++) {
                sum += input.get(j);
                if (sum > invalidNumber) {
                    break;
                } else if (sum == invalidNumber && (j-i) >= minSetSize) {
                    return new HashSet<>(input.subList(i, j+1));
                }
            }
        }
        return ImmutableSet.of();
    }
}

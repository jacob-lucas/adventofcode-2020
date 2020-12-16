package com.jacoblucas.adventofcode2020.day15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MemoryGame {
    private final List<Integer> input;

    // number to recent turns
    private Map<Integer, Integer> memory;

    public MemoryGame(final List<Integer> input) {
        this.input = input;
    }

    public int get(final int n) {
        this.memory = new HashMap<>();

        // set up the first n turns, where n == input.size()
        IntStream.range(0, input.size()).forEach(i -> memory.put(input.get(i), i));

        final int turn = input.size() - 1;
        int k = input.get(turn);
        for (int i=turn; i<n-1; i++) {
            final Integer last = memory.get(k);
            memory.put(k, i);
            k = last == null ? 0 : i - last;
        }
        return k;
    }
}

package com.jacoblucas.adventofcode2020.day15;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryGame {
    private final List<Integer> input;

    // number to recent turns
    private Map<Integer, List<Integer>> memory;

    public MemoryGame(final List<Integer> input) {
        this.input = input;
    }

    public void init() {
        this.memory = new HashMap<>();

        // set up the first n turns, where n == input.size()
        for (int i=1; i<=input.size(); i++) {
            memory.put(input.get(i-1), new ArrayList<>(ImmutableList.of(i)));
        }
    }

    public int get(final int n) {
        init();
        int k = input.size();
        int last = input.get(input.size() - 1);
        while (k < n) {
            last = turn(k + 1, last);
            k++;
        }
        return last;
    }

    int turn(final int n, final int last) {
        final List<Integer> turns = memory.getOrDefault(last, ImmutableList.of());
        final int spoken;
        if (turns.size() < 2) {
            spoken = 0;
        } else {
            final int lastTurn = turns.get(turns.size() - 1);
            final int secondLastTurn = turns.get(turns.size() - 2);
            spoken = lastTurn - secondLastTurn;
        }

        List<Integer> existing = memory.getOrDefault(spoken, new ArrayList<>());
        existing.add(n);
        if (existing.size() > 2) {
            existing = existing.subList(existing.size()-2, existing.size());
        }
        memory.put(spoken, existing);
        return spoken;
    }
}

package com.jacoblucas.adventofcode2020.day10;

import com.google.common.collect.ImmutableMap;
import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day10 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day10-input.txt");
        final List<JoltageAdapter> adapters = parse(lines);
        final List<JoltageAdapter> chain = chain(adapters);

        final int ones = countDifferences(chain, 1);
        final int threes = countDifferences(chain, 3);
        System.out.println(ones * threes);

        System.out.println(countCombinations(chain));
    }

    public static List<JoltageAdapter> parse(final List<String> input) {
        return input.stream()
                .mapToInt(Integer::parseInt)
                .mapToObj(ImmutableJoltageAdapter::of)
                .collect(Collectors.toList());
    }

    public static List<JoltageAdapter> chain(final List<JoltageAdapter> adapters) {
        return adapters.stream()
                .sorted(Comparator.comparing(JoltageAdapter::getOutput))
                .collect(Collectors.toList());
    }

    public static int countDifferences(final List<JoltageAdapter> adapters, final int n) {
        int count = 0;
        for (int i=1; i<adapters.size(); i++) {
            if (adapters.get(i).getOutput() - adapters.get(i-1).getOutput() == n) {
                count++;
            }
        }
        return count;
    }

    public static List<JoltageAdapter> outletToDevice(final List<JoltageAdapter> adapters) {
        final JoltageAdapter outlet = ImmutableJoltageAdapter.of(0);
        final JoltageAdapter deviceAdapter = new Device().getBuiltInAdapter(adapters);

        final List<JoltageAdapter> chain = new ArrayList<>();
        chain.add(outlet);
        chain.addAll(adapters);
        chain.add(deviceAdapter);
        return chain;
    }

    public static long countCombinations(final List<JoltageAdapter> adapters) {
        final Map<Integer, Map<List<JoltageAdapter>, Long>> cache = new HashMap<>();
        return countCombinations(adapters, 0, cache);
    }

    private static long countCombinations(final List<JoltageAdapter> adapters, final int previousCount, final Map<Integer, Map<List<JoltageAdapter>, Long>> cache) {
        if (adapters.isEmpty()) {
            return 1;
        } else if (cache.containsKey(previousCount)) {
            return cache.get(previousCount).get(adapters);
        } else {
            final JoltageAdapter next = adapters.remove(0);
            long count = countCombinations(adapters, next.getOutput(), cache);

            if (!adapters.isEmpty() && adapters.get(0).isValidInput(previousCount)) {
                count += countCombinations(adapters, previousCount, cache);
            }

            adapters.add(0, next);
            cache.put(previousCount, ImmutableMap.of(adapters, count));
            return count;
        }
    }
}

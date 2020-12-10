package com.jacoblucas.adventofcode2020.day10;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day10-input.txt");
        final List<JoltageAdapter> adapters = parse(lines);
        final List<JoltageAdapter> chain = chain(adapters);

        final int ones = countDifferences(chain, 1);
        final int threes = countDifferences(chain, 3);
        System.out.println(ones * threes);
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
        final JoltageAdapter outlet = ImmutableJoltageAdapter.of(0);
        final JoltageAdapter deviceAdapter = new Device().getBuiltInAdapter(adapters);

        final List<JoltageAdapter> chain = new ArrayList<>();
        chain.add(outlet);
        chain.addAll(adapters);
        chain.add(deviceAdapter);

        int count = 0;
        for (int i=1; i<chain.size(); i++) {
            if (chain.get(i).getOutput() - chain.get(i-1).getOutput() == n) {
                count++;
            }
        }
        return count;
    }
}

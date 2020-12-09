package com.jacoblucas.adventofcode2020.day9;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day9 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day9-input.txt");
        final List<Long> numbers = toLongList(lines);

        final XMAS xmas = new XMAS(25);
        final int invalidIdx = xmas.findFirstInvalid(numbers);
        final long invalid = numbers.get(invalidIdx);
        System.out.println(invalid);

        final Set<Long> weakness = xmas.findWeakness(invalid, numbers, 2);
        final long min = weakness.stream().min(Comparator.naturalOrder()).orElse(-1L);
        final long max = weakness.stream().max(Comparator.naturalOrder()).orElse(-1L);
        System.out.println(min + max);
    }

    static List<Long> toLongList(List<String> lines) {
        return lines.stream()
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
    }
}

package com.jacoblucas.adventofcode2020.day9;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day9 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day9-input.txt");
        final List<Long> numbers = toLongList(lines);

        final XMAS xmas = new XMAS(25);
        final int invalid = xmas.findFirstInvalid(numbers);
        System.out.println(numbers.get(invalid));
    }

    static List<Long> toLongList(List<String> lines) {
        return lines.stream()
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
    }
}

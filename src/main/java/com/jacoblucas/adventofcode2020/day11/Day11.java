package com.jacoblucas.adventofcode2020.day11;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Day11 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day11-input.txt");
        System.out.println(part1(SeatLayout.parse(lines)));
        System.out.println(part2(SeatLayout.parse(lines)));
    }

    public static long part1(final SeatLayout seatLayout) {
        boolean updating = true;
        while (updating) {
            updating = seatLayout.iterate();
        }

        return Stream.of(seatLayout.grid)
                .mapToLong(ps -> Stream.of(ps)
                        .filter(p -> p == Position.OCCUPIED)
                        .count())
                .sum();
    }

    public static long part2(final SeatLayout seatLayout) {
        boolean updating = true;
        while (updating) {
            updating = seatLayout.iterateV2();
        }

        return Stream.of(seatLayout.grid)
                .mapToLong(ps -> Stream.of(ps)
                        .filter(p -> p == Position.OCCUPIED)
                        .count())
                .sum();
    }
}

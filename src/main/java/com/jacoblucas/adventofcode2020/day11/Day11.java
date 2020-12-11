package com.jacoblucas.adventofcode2020.day11;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Day11 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day11-input.txt");
        final SeatLayout seatLayout = SeatLayout.parse(lines);

        System.out.println(part1(seatLayout));
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
}

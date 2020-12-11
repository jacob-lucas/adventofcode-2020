package com.jacoblucas.adventofcode2020.day11;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day11Test {
    @Test
    public void testPart1() throws IOException {
        final List<String> input = InputReader.readFile("src/test/resources/", "day11-test-input-p1.txt");
        final SeatLayout seatLayout = SeatLayout.parse(input);

        final long occupied = Day11.part1(seatLayout);
        assertThat(occupied, is(37L));
    }

    @Test
    public void testPart2() throws IOException {
        final List<String> input = InputReader.readFile("src/test/resources/", "day11-test-input-p1.txt");
        final SeatLayout seatLayout = SeatLayout.parse(input);

        final long occupied = Day11.part2(seatLayout);
        assertThat(occupied, is(26L));
    }
}

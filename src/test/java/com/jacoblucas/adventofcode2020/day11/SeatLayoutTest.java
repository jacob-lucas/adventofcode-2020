package com.jacoblucas.adventofcode2020.day11;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jacoblucas.adventofcode2020.day11.Position.EMPTY;
import static com.jacoblucas.adventofcode2020.day11.Position.FLOOR;
import static com.jacoblucas.adventofcode2020.day11.Position.OCCUPIED;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SeatLayoutTest {
    private SeatLayout seatLayout;

    @Before
    public void setUp() {
        final List<String> input = ImmutableList.of(
                "L.#",
                "...",
                "LLL",
                "###");
        seatLayout = SeatLayout.parse(input);
    }

    @Test
    public void testParse() {
        final Position[][] expected = {
                {EMPTY, FLOOR, OCCUPIED},
                {FLOOR, FLOOR, FLOOR},
                {EMPTY, EMPTY, EMPTY},
                {OCCUPIED, OCCUPIED, OCCUPIED}};

        assertThat(seatLayout.grid, is(expected));
    }

    @Test
    public void testCountAdjacent() {
        assertThat(seatLayout.countAdjacent(0,0, FLOOR), is(3));
        assertThat(seatLayout.countAdjacent(0,0, OCCUPIED), is(0));
        assertThat(seatLayout.countAdjacent(1,1, EMPTY), is(4));
    }

    @Test
    public void testIterate() throws IOException {
        final List<String> input = InputReader.readFile("src/test/resources/", "day11-test-input-p1.txt");
        final SeatLayout seatLayout = SeatLayout.parse(input);

        final List<String> expected = new ArrayList<>();
        expected.add("#.##.##.##");
        expected.add("#######.##");
        expected.add("#.#.#..#..");
        expected.add("####.##.##");
        expected.add("#.##.##.##");
        expected.add("#.#####.##");
        expected.add("..#.#.....");
        expected.add("##########");
        expected.add("#.######.#");
        expected.add("#.#####.##");

        seatLayout.iterate();

        final List<String> iteration = Stream.of(seatLayout.grid)
                .map(ps -> Stream.of(ps)
                        .map(p -> p.value)
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());

        assertThat(iteration, is(expected));
    }

    @Test
    public void testCountVisibleExample1() {
        final List<String> input = ImmutableList.of(
                ".......#.",
                "...#.....",
                ".#.......",
                ".........",
                "..#L....#",
                "....#....",
                ".........",
                "#........",
                "...#.....");
        final SeatLayout seatLayout = SeatLayout.parse(input);
        assertThat(seatLayout.countVisible(3, 4, OCCUPIED), is(8));
    }

    @Test
    public void testCountVisibleExample2() {
        final List<String> input = ImmutableList.of(
                ".............",
                ".L.L.#.#.#.#.",
                ".............");
        final SeatLayout seatLayout = SeatLayout.parse(input);
        assertThat(seatLayout.countVisible(1, 1, OCCUPIED), is(0));
    }

    @Test
    public void testCountVisibleExample3() {
        final List<String> input = ImmutableList.of(
                ".##.##.",
                "#.#.#.#",
                "##...##",
                "...L...",
                "##...##",
                "#.#.#.#",
                ".##.##.");
        final SeatLayout seatLayout = SeatLayout.parse(input);
        assertThat(seatLayout.countVisible(3, 3, OCCUPIED), is(0));
    }
}

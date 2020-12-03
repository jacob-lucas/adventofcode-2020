package com.jacoblucas.adventofcode2020.day3;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day3Test {
    @Test
    public void testParse() {
        final List<String> lines = ImmutableList.of(
                "..##",
                "#...",
                ".#..",
                ".#..");

        final char[][] chars = {
            {'.','.','#','#'},
            {'#','.','.','.'},
            {'.','#','.','.'},
            {'.','#','.','.'}
        };

        assertThat(Day3.parse(lines), is(chars));
    }

    @Test
    public void testCountTrees() {
        final List<String> lines = ImmutableList.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        final char[][] map = Day3.parse(lines);
        final Pair<Direction, Integer> r3 = ImmutablePair.of(Direction.RIGHT, 3);
        final Pair<Direction, Integer> d1 = ImmutablePair.of(Direction.DOWN, 1);
        final List<Pair<Direction, Integer>> slope = ImmutableList.of(r3, d1);

        final long trees = Day3.countTrees(0, 0, map, slope);

        assertThat(trees, is(7L));
    }
}

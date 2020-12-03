package com.jacoblucas.adventofcode2020.day3;

import com.google.common.collect.ImmutableList;
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
        final Instruction r3 = ImmutableInstruction.of(Direction.RIGHT, 3);
        final Instruction d1 = ImmutableInstruction.of(Direction.DOWN, 1);
        final List<Instruction> slope = ImmutableList.of(r3, d1);

        final long trees = Day3.countTrees(0, 0, map, slope);

        assertThat(trees, is(7L));
    }
}

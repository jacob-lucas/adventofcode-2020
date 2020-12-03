package com.jacoblucas.adventofcode2020.day3;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.Calculator;
import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import com.jacoblucas.adventofcode2020.utils.Pair;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day3 {
    private static final char TREE = '#';

    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day3-input.txt");
        final char[][] map = parse(lines);

        final Pair<Direction, Integer> r3 = ImmutablePair.of(Direction.RIGHT, 3);
        final Pair<Direction, Integer> d1 = ImmutablePair.of(Direction.DOWN, 1);
        final long trees = countTrees(0, 0, map, ImmutableList.of(r3, d1));
        System.out.println(trees);

        final Pair<Direction, Integer> r1 = ImmutablePair.of(Direction.RIGHT, 1);
        final Pair<Direction, Integer> r5 = ImmutablePair.of(Direction.RIGHT, 5);
        final Pair<Direction, Integer> r7 = ImmutablePair.of(Direction.RIGHT, 7);
        final Pair<Direction, Integer> d2 = ImmutablePair.of(Direction.DOWN, 2);

        final long result = trees * Calculator.longProduct(
                ImmutableList.of(ImmutableList.of(r1, d1), ImmutableList.of(r5, d1), ImmutableList.of(r7, d1), ImmutableList.of(r1, d2))
                        .stream()
                        .map(instructions -> countTrees(0, 0, map, instructions))
                        .collect(Collectors.toList()));
        System.out.println(result);
    }

    public static long countTrees(final int x, final int y, final char[][] map, final List<Pair<Direction, Integer>> slope) {
        int[][] count = new int[map.length][map[0].length];
        return countTrees(x, y, map, slope, count);
    }

    private static long countTrees(final int x, final int y, final char[][] map, final List<Pair<Direction, Integer>> slope, final int[][] count) {
        int newX = x;
        int newY = y;
        for (final Pair<Direction, Integer> instruction : slope) {
            final Direction direction = instruction.getFirst();
            final int amount = instruction.getSecond();

            if (direction == Direction.LEFT || direction == Direction.RIGHT) {
                newX += (direction.getDelta() * amount);
            } else {
                newY += (direction.getDelta() * amount);
                if (newY >= map.length) {
                    return Stream.of(count)
                            .map(IntStream::of)
                            .mapToInt(IntStream::sum)
                            .sum();
                }
            }
        }

        final int infX = newX % map[0].length;
        if (map[newY][infX] == TREE) {
            count[newY][infX] = 1;
        }

        return countTrees(newX, newY, map, slope, count);
    }

    public static char[][] parse(List<String> lines) {
        int height = lines.size();
        final char[][] result = new char[height][];

        for (int i = 0; i < lines.size(); i++) {
            result[i] = lines.get(i).toCharArray();
        }

        return result;
    }
}

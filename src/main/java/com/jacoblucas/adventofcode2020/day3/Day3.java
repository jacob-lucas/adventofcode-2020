package com.jacoblucas.adventofcode2020.day3;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day3 {
    private static final char TREE = '#';

    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day3-input.txt");
        final char[][] map = parse(lines);

        final Instruction r3 = ImmutableInstruction.of(Direction.RIGHT, 3);
        final Instruction d1 = ImmutableInstruction.of(Direction.DOWN, 1);
        final long trees = countTrees(0, 0, map, ImmutableList.of(r3, d1));
        System.out.println(trees);
    }

    public static long countTrees(final int x, final int y, final char[][] map, final List<Instruction> slope) {
        int[][] count = new int[map.length][map[0].length];
        return countTrees(x, y, map, slope, count);
    }

    private static long countTrees(final int x, final int y, final char[][] map, final List<Instruction> slope, final int[][] count) {
        if (y >= map.length) {
            return Stream.of(count)
                    .map(IntStream::of)
                    .mapToInt(IntStream::sum)
                    .sum();
        }

        int newX = x;
        int newY = y;
        for (final Instruction instruction : slope) {
            final Direction direction = instruction.getDirection();
            final int amount = instruction.getAmount();

            if (direction == Direction.LEFT || direction == Direction.RIGHT) {
                newX += (direction.getDelta() * amount);
//                for (int i = x; i <= newX; i++) {
//                    final int pos = i % map[0].length;
//                    if (map[newY][pos] == TREE) {
//                        count[newY][pos] = 1;
//                    }
//                }
            } else {
//                final int pos = newX % map[0].length;
                newY += (direction.getDelta() * amount);
                if (newY >= map.length) {
                    return countTrees(newX, newY, map, slope, count);
                }
//                for (int i = y; i <= newY; i++) {
//                    if (map[i][pos] == TREE) {
//                        count[i][pos] = 1;
//                    }
//                }
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

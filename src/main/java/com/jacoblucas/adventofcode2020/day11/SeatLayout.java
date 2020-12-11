package com.jacoblucas.adventofcode2020.day11;

import io.vavr.collection.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.jacoblucas.adventofcode2020.day11.Position.EMPTY;
import static com.jacoblucas.adventofcode2020.day11.Position.FLOOR;
import static com.jacoblucas.adventofcode2020.day11.Position.OCCUPIED;

public class SeatLayout {
    Position[][] grid;

    public SeatLayout(final Position[][] grid) {
        this.grid = grid;
    }

    public static SeatLayout parse(List<String> input) {
        final List<List<Position>> positionList = input.stream()
                .map(str -> Stream.ofAll(str.toCharArray())
                        .map(ch -> Position.of("" + ch))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        Position[][] grid = new Position[positionList.size()][];
        for (int i=0; i<positionList.size(); i++) {
            grid[i] = positionList.get(i).toArray(new Position[]{});
        }

        return new SeatLayout(grid);
    }

    public int countAdjacent(final int x, final int y, final Position value) {
        int count = 0;
        for (int j=-1; j<=1; j++) {
            for (int i=-1; i<=1; i++) {
                if (offGrid(x+i, y+j) || (j == 0 && i == 0)) {
                    continue;
                }

                final Position position = grid[y+j][x+i];
                if (position == value) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countVisible(final int x, final int y, final Position position) {
        int count = 0;
        for (int j=-1; j<=1; j++) {
            for (int i=-1; i<=1; i++) {
                int x1 = x + i;
                int y1 = y + j;
                if (offGrid(x1, y1) || (j == 0 && i == 0)) {
                    continue;
                }

                while (!offGrid(x1, y1) && grid[y1][x1] == FLOOR) {
                    y1 += j;
                    x1 += i;
                }

                if (!offGrid(x1, y1) && grid[y1][x1] == position) {
                    count++;
                }
            }
        }
        return count;
    }

    // Returns true if the grid was updated, false otherwise
    public boolean iterate() {
        final Position[][] next = new Position[grid.length][grid[0].length];
        for (int j=0; j<grid.length; j++) {
            for (int i=0; i<grid[0].length; i++) {
                final Position curr = grid[j][i];
                if (curr == EMPTY && countAdjacent(i, j, OCCUPIED) == 0) {
                    next[j][i] = OCCUPIED;
                } else if (curr == OCCUPIED && countAdjacent(i, j, OCCUPIED) >= 4) {
                    next[j][i] = EMPTY;
                } else {
                    next[j][i] = curr;
                }
            }
        }

        // Did the iteration not change anything?
        boolean equal = Arrays.deepEquals(grid, next);

        grid = next;
        return !equal;
    }

    // Returns true if the grid was updated, false otherwise
    public boolean iterateV2() {
        final Position[][] next = new Position[grid.length][grid[0].length];
        for (int j=0; j<grid.length; j++) {
            for (int i=0; i<grid[0].length; i++) {
                final Position curr = grid[j][i];
                if (curr == EMPTY && countVisible(i, j, OCCUPIED) == 0) {
                    next[j][i] = OCCUPIED;
                } else if (curr == OCCUPIED && countVisible(i, j, OCCUPIED) >= 5) {
                    next[j][i] = EMPTY;
                } else {
                    next[j][i] = curr;
                }
            }
        }

        // Did the iteration not change anything?
        boolean equal = Arrays.deepEquals(grid, next);

        grid = next;
        return !equal;
    }

    private boolean offGrid(final int x, final int y) {
        return y < 0 || y >= grid.length || x < 0 || x >= grid[0].length;
    }
}

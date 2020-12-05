package com.jacoblucas.adventofcode2020.day5;

import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.Pair;
import org.immutables.value.Value;

@Value.Immutable
public abstract class Plane {
    public abstract int[] getRows();

    public abstract int[] getColumns();

    public Pair<Integer, Integer> findSeat(final BoardingPass boardingPass) {
        return ImmutablePair.of(
                find(boardingPass.getRow(), 0, getRows().length - 1),
                find(boardingPass.getSeat(), 0, getColumns().length - 1));
    }

    private int find(final String input, final int lower, final int upper) {
        if (input.isEmpty()) {
            return Math.min(lower, upper);
        }

        final char ch = input.charAt(0);
        final int half = lower + (upper - lower) / 2;
        if (ch == 'F' || ch == 'L') {
            return find(input.substring(1), lower, half);
        } else {
            // ch == 'B' || ch == 'R'
            return find(input.substring(1), half + 1, upper);
        }
    }

    public int getSeatId(final Integer row, final Integer column) {
        return row * 8 + column;
    }
}

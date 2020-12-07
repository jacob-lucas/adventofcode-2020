package com.jacoblucas.adventofcode2020.day5;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day5-input.txt");

        final List<BoardingPass> boardingPasses = lines.stream()
                .map(ImmutableBoardingPass::of)
                .collect(Collectors.toList());

        final Plane plane = ImmutablePlane.builder()
                .rows(new int[128])
                .columns(new int[8])
                .build();

        final List<Integer> seatIds = toSeatIds(boardingPasses, plane);
        System.out.println(seatIds.get(seatIds.size() - 1));

        for (int i=1; i<seatIds.size(); i++) {
            final int id1 = seatIds.get(i-1);
            final int id2 = seatIds.get(i);

            if (id2 - id1 > 1) {
                System.out.println(id2 - 1);
                break;
            }
        }
    }

    public static List<Integer> toSeatIds(final List<BoardingPass> boardingPasses, final Plane plane) {
        return boardingPasses.stream()
                .map(plane::findSeat)
                .map(p -> plane.getSeatId(p.getFirst(), p.getSecond()))
                .sorted()
                .collect(Collectors.toList());
    }
}

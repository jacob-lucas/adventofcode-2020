package com.jacoblucas.adventofcode2020.day5;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.Comparator;
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

        final int highestSeatId = boardingPasses.stream()
                .map(plane::findSeat)
                .map(p -> plane.getSeatId(p.getFirst(), p.getSecond()))
                .max(Comparator.naturalOrder())
                .orElse(-1);

        System.out.println(highestSeatId);
    }
}

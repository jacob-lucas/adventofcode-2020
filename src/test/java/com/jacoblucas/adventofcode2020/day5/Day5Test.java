package com.jacoblucas.adventofcode2020.day5;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day5Test {

    private Plane plane;

    @Before
    public void setUp() {
        plane = ImmutablePlane.builder()
                .rows(new int[128])
                .columns(new int[8])
                .build();
    }

    @Test
    public void testToSeatIds() {
        final List<BoardingPass> boardingPasses = ImmutableList.of("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")
                .stream()
                .map(ImmutableBoardingPass::of)
                .collect(Collectors.toList());

        final List<Integer> seatIds = Day5.toSeatIds(boardingPasses, plane);

        assertThat(seatIds, is(ImmutableList.of(119, 567, 820)));
    }
}

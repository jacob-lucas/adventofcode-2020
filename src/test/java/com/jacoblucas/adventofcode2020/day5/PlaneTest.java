package com.jacoblucas.adventofcode2020.day5;

import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlaneTest {

    private Plane plane;

    @Before
    public void setUp() {
        plane = ImmutablePlane.builder()
                .rows(new int[128])
                .columns(new int[8])
                .build();
    }

    @Test
    public void example1() {
        final Pair<Integer, Integer> seat = plane.findSeat(ImmutableBoardingPass.of("FBFBBFFRLR"));
        assertThat(seat, is(ImmutablePair.of(44, 5)));
        assertThat(plane.getSeatId(seat.getFirst(), seat.getSecond()), is(357));
    }

    @Test
    public void example2() {
        final Pair<Integer, Integer> seat = plane.findSeat(ImmutableBoardingPass.of("BFFFBBFRRR"));
        assertThat(seat, is(ImmutablePair.of(70, 7)));
        assertThat(plane.getSeatId(seat.getFirst(), seat.getSecond()), is(567));
    }

    @Test
    public void example3() {
        final Pair<Integer, Integer> seat = plane.findSeat(ImmutableBoardingPass.of("FFFBBBFRRR"));
        assertThat(seat, is(ImmutablePair.of(14, 7)));
        assertThat(plane.getSeatId(seat.getFirst(), seat.getSecond()), is(119));
    }

    @Test
    public void example4() {
        final Pair<Integer, Integer> seat = plane.findSeat(ImmutableBoardingPass.of("BBFFBBFRLL"));
        assertThat(seat, is(ImmutablePair.of(102, 4)));
        assertThat(plane.getSeatId(seat.getFirst(), seat.getSecond()), is(820));
    }
}

package com.jacoblucas.adventofcode2020.utils;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void intProductMultipliesAll() {
        final Set<Integer> input = ImmutableSet.of(979, 366, 675);
        assertThat(Calculator.intProduct(input), is(241861950));
    }

    @Test
    public void intProductOfEmptySet() {
        final Set<Integer> input = ImmutableSet.of();
        assertThat(Calculator.intProduct(input), is(0));
    }

    @Test
    public void longProductMultipliesAll() {
        final Set<Long> input = ImmutableSet.of(979L, 366L, 675L);
        assertThat(Calculator.longProduct(input), is(241861950L));
    }

    @Test
    public void longProductOfEmptySet() {
        final Set<Long> input = ImmutableSet.of();
        assertThat(Calculator.longProduct(input), is(0L));
    }

    @Test
    public void testManhattanDistance() {
        assertThat(Calculator.manhattanDistance(-7, -4, 17, 6), is(34));
        assertThat(Calculator.manhattanDistance(17, 6, -7, -4), is(34));
        assertThat(Calculator.manhattanDistance(0, 0, 3, 3), is(6));
        assertThat(Calculator.manhattanDistance(3, 3, 0, 0), is(6));
        assertThat(Calculator.manhattanDistance(3, 3, 3, 3), is(0));
        assertThat(Calculator.manhattanDistance(1, 1, 9, 9), is(16));
    }
}

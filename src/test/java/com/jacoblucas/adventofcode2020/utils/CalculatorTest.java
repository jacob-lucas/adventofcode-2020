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
}

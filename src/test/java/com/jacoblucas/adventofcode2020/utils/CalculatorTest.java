package com.jacoblucas.adventofcode2020.utils;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void productMultipliesAll() {
        final Set<Integer> input = ImmutableSet.of(979, 366, 675);
        assertThat(Calculator.product(input), is(241861950));
    }

    @Test
    public void productOfEmptySet() {
        final Set<Integer> input = ImmutableSet.of();
        assertThat(Calculator.product(input), is(0));
    }
}

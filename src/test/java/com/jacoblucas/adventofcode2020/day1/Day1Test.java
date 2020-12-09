package com.jacoblucas.adventofcode2020.day1;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

public class Day1Test {
    private static final Set<Long> INPUT = ImmutableSet.of(1721L, 979L, 366L, 299L, 675L, 1456L);
    @Test
    public void findTwoWithResult() {
        final Set<Long> pair = Day1.findTwo(2020, INPUT);
        assertThat(pair, is(ImmutableSet.of(1721L, 299L)));
    }

    @Test
    public void findTwoWithoutResult() {
        final Set<Long> input = ImmutableSet.of(1721L, 979L, 366L, 2999L, 675L, 1456L);
        final Set<Long> pair = Day1.findTwo(2020, input);
        assertThat(pair, is(empty()));
    }

    @Test
    public void findThreeWithResult() {
        final Set<Long> result = Day1.findThree(2020, INPUT);
        assertThat(result, is(ImmutableSet.of(979L, 366L, 675L)));
    }

    @Test
    public void findThreeWithoutResult() {
        final Set<Long> input = ImmutableSet.of(1721L, 9799L, 366L, 2999L, 675L, 1456L);
        final Set<Long> result = Day1.findThree(2020, input);
        assertThat(result, is(empty()));
    }
}

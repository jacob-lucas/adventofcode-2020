package com.jacoblucas.adventofcode2020.day1;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

public class Day1Test {
    @Test
    public void findTwoWithResult() {
        final Set<Integer> input = ImmutableSet.of(1721, 979, 366, 299, 675, 1456);
        final Set<Integer> pair = Day1.findTwo(2020, input);
        assertThat(pair, is(ImmutableSet.of(1721, 299)));
    }

    @Test
    public void findTwoWithoutResult() {
        final Set<Integer> input = ImmutableSet.of(1721, 979, 366, 2999, 675, 1456);
        final Set<Integer> pair = Day1.findTwo(2020, input);
        assertThat(pair, is(empty()));
    }

    @Test
    public void findThreeWithResult() {
        final Set<Integer> input = ImmutableSet.of(1721, 979, 366, 299, 675, 1456);
        final Set<Integer> result = Day1.findThree(2020, input);
        assertThat(result, is(ImmutableSet.of(979, 366, 675)));
    }

    @Test
    public void findThreeWithoutResult() {
        final Set<Integer> input = ImmutableSet.of(1721, 9799, 366, 2999, 675, 1456);
        final Set<Integer> result = Day1.findThree(2020, input);
        assertThat(result, is(empty()));
    }
}

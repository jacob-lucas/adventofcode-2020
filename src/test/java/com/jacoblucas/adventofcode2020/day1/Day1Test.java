package com.jacoblucas.adventofcode2020.day1;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

public class Day1Test {
    @Test
    public void sumToWithResult() {
        final Set<Integer> input = ImmutableSet.of(1721, 979, 366, 299, 675, 1456);
        final Set<Integer> pair = Day1.sumTo(2020, input);
        assertThat(pair, is(ImmutableSet.of(1721, 299)));
    }

    @Test
    public void sumToWithoutResult() {
        final Set<Integer> input = ImmutableSet.of(1721, 979, 366, 2999, 675, 1456);
        final Set<Integer> pair = Day1.sumTo(2020, input);
        assertThat(pair, is(empty()));
    }
}

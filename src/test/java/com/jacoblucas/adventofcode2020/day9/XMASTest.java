package com.jacoblucas.adventofcode2020.day9;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class XMASTest {

    private List<Long> input;
    private XMAS xmas;

    @Before
    public void setUp() throws IOException {
        input = Day9.toLongList(InputReader.readFile("src/test/resources/", "day9-test-input-p1.txt"));
        xmas = new XMAS(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputSizeUnderPreamble() {
        xmas.findFirstInvalid(ImmutableList.of(1L, 2L, 3L));
    }

    @Test
    public void example1() {
        final int invalid = xmas.findFirstInvalid(input);

        assertThat(input.get(invalid), is(127L));
    }

    @Test
    public void testFindWeakness() {
        final int invalid = xmas.findFirstInvalid(input);
        final long n = input.get(invalid);

        final Set<Long> weakness = xmas.findWeakness(n, input, 2);

        assertThat(weakness, is(ImmutableSet.of(15L,25L,47L,40L)));
    }
}

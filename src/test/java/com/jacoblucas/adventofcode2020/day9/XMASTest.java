package com.jacoblucas.adventofcode2020.day9;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class XMASTest {
    private static final String TEST_PATH = "src/test/resources/";

    @Test(expected = IllegalArgumentException.class)
    public void testInputSizeUnderPreamble() {
        final XMAS xmas = new XMAS(3);
        xmas.findFirstInvalid(ImmutableList.of(1L, 2L));
    }

    @Test
    public void example1() throws IOException {
        final List<Long> input = Day9.toLongList(InputReader.readFile(TEST_PATH, "day9-test-input-p1.txt"));
        final XMAS xmas = new XMAS(5);

        final int invalid = xmas.findFirstInvalid(input);

        assertThat(input.get(invalid), is(127L));
    }
}

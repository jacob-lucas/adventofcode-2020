package com.jacoblucas.adventofcode2020.day2;

import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day2Test {
    @Test
    public void testParseValidLine() {
        final String line = "1-3 a: abcde";
        final Pair<PasswordPolicy, String> parsed = Day2.parse(line);

        assertThat(parsed.getFirst(), is(ImmutablePasswordPolicy.builder()
                .minimum(1)
                .maximum(3)
                .letter('a')
                .build()));

        assertThat(parsed.getSecond(), is("abcde"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidLine() {
        final String line = "";
        Day2.parse(line);
    }
}

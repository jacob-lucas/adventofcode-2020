package com.jacoblucas.adventofcode2020.day2;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void testCountValid() {
        final String line1 = "1-3 a: abcde";
        final String line2 = "1-3 b: cdefg";
        final String line3 = "2-9 c: ccccccccc";

        final List<Pair<PasswordPolicy, String>> passwords = ImmutableList.of(line1, line2, line3)
                .stream()
                .map(Day2::parse)
                .collect(Collectors.toList());

        assertThat(Day2.countValid(passwords, new PasswordValidatorV1()), is(2L));
    }
}

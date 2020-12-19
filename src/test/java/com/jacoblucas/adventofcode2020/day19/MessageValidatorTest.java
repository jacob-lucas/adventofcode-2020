package com.jacoblucas.adventofcode2020.day19;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class MessageValidatorTest {
    private MessageValidator validator;

    @Before
    public void setUp() {
        final List<String> rules = ImmutableList.of(
                "0: 4 1 5",
                "1: 2 3 | 3 2",
                "2: 4 4 | 5 5",
                "3: 4 5 | 5 4",
                "4: \"a\"",
                "5: \"b\"");

        validator = new MessageValidator(Day19.parseRules(rules));
    }

    @Test
    public void testResolve() {
        final String pattern = validator.resolve(0);
        assertThat(pattern, is("^a((aa|bb)(ab|ba)|(ab|ba)(aa|bb))b$"));
    }

    @Test
    public void testPatternMatch() {
        // 0: 4 1 5      => a((aa|bb)(ab|ba)|(ab|ba)(aa|bb))b
        // 1: 2 3 | 3 2  => ((aa|bb)(ab|ba)|(ab|ba)(aa|bb))
        // 2: 4 4 | 5 5  => (aa|bb)
        // 3: 4 5 | 5 4  => (ab|ba)
        // 4: "a"        => a
        // 5: "b"        => b

        // https://regexr.com/5isgv
        final Pattern pattern = Pattern.compile("^a((aa|bb)(ab|ba)|(ab|ba)(aa|bb))b$");
        final List<String> messages = ImmutableList.of(
                "ababbb",
                "bababa",
                "abbbab",
                "aaabbb",
                "aaaabbb");

        final List<String> matches = validator.match(pattern, messages);

        assertThat(matches, containsInAnyOrder("ababbb", "abbbab"));
    }
}

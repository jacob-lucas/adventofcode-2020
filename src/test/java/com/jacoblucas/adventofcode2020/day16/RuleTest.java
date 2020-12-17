package com.jacoblucas.adventofcode2020.day16;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import io.vavr.control.Try;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RuleTest {
    @Test
    public void testParse() {
        final String input = "row: 6-11 or 33-44";
        final Try<Rule> rule = Rule.parse(input);
        assertThat(rule.get(), is(ImmutableRule.builder()
                .field("row")
                .validRanges(ImmutableList.of(
                        ImmutablePair.of(6, 11),
                        ImmutablePair.of(33, 44)))
                .build()));
    }
    @Test
    public void testParseLongField() {
        final String input = "departure location: 44-401 or 415-965";
        final Try<Rule> rule = Rule.parse(input);
        assertThat(rule.get(), is(ImmutableRule.builder()
                .field("departure location")
                .validRanges(ImmutableList.of(
                        ImmutablePair.of(44, 401),
                        ImmutablePair.of(415, 965)))
                .build()));
    }

    @Test
    public void testIsValid() {
        final Rule rule = Rule.parse("row: 6-11 or 33-44").get();
        assertThat(rule.isValid(7), is(true));
        assertThat(rule.isValid(17), is(false));
    }
}

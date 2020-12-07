package com.jacoblucas.adventofcode2020.day7;

import com.google.common.collect.ImmutableMap;
import io.vavr.control.Try;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RuleTest {
    @Test
    public void testInvalidRule() {
        final Try<Rule> bag = Rule.parse("this is not a valid rule");
        assertThat(bag.isFailure(), is(true));
    }

    @Test
    public void testParseWithEmptyContents() {
        final String input = "dotted black bags contain no other bags.";
        final Try<Rule> bag = Rule.parse(input);

        assertThat(bag.get(), is(ImmutableRule.builder()
                .colour("dotted black")
                .build()));
    }

    @Test
    public void testParseWithSingleContents() {
        final String input = "bright white bags contain 1 shiny gold bag";
        final Try<Rule> bag = Rule.parse(input);

        assertThat(bag.get(), is(ImmutableRule.builder()
                .colour("bright white")
                .contentsByColour(ImmutableMap.of("shiny gold", 1))
                .build()));
    }

    @Test
    public void testParseWithMultipleContents() {
        final String input = "light red bags contain 1 bright white bag, 2 muted yellow bags.";
        final Try<Rule> bag = Rule.parse(input);

        assertThat(bag.get(), is(ImmutableRule.builder()
                .colour("light red")
                .contentsByColour(ImmutableMap.of(
                        "bright white", 1,
                        "muted yellow", 2))
                .build()));
    }
}

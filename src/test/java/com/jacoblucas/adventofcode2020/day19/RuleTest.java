package com.jacoblucas.adventofcode2020.day19;

import com.google.common.collect.ImmutableList;
import io.vavr.control.Try;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RuleTest {
    @Test
    public void parseInvalid() {
        final Try<Rule> rule = Rule.parse("abc");
        assertThat(rule.isSuccess(), is(false));
    }

    @Test
    public void parsePairChoiceRule() {
        final Try<Rule> rule = Rule.parse("2: 1 3 | 3 1");
        assertThat(rule.isSuccess(), is(true));
        assertThat(rule.get(), is(ImmutableChoiceRule.builder()
                .id(2)
                .addAllChoices(ImmutableList.of(
                        ImmutableList.of(1, 3),
                        ImmutableList.of(3, 1)))
                .build()));
    }

    @Test
    public void parsePairRule() {
        final Try<Rule> rule = Rule.parse("0: 1 2 3");
        assertThat(rule.isSuccess(), is(true));
        assertThat(rule.get(), is(ImmutableListRule.builder()
                .id(0)
                .ruleIds(ImmutableList.of(1, 2, 3))
                .build()));
    }

    @Test
    public void parseLetterRule() {
        final Try<Rule> rule = Rule.parse("1: \"a\"");
        assertThat(rule.isSuccess(), is(true));
        assertThat(rule.get(), is(ImmutableLetterRule.builder()
                .id(1)
                .letter('a')
                .build()));
    }
}

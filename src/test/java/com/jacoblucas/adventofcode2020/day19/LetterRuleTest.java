package com.jacoblucas.adventofcode2020.day19;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LetterRuleTest {
    @Test
    public void resolvePattern() {
        final Rule rule = ImmutableLetterRule.builder()
                .id(1)
                .letter('c')
                .build();
        assertThat(rule.resolvePattern(ImmutableMap.of()), is("c"));
    }
}

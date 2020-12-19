package com.jacoblucas.adventofcode2020.day19;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChoiceRuleTest {
    @Test
    public void resolvePatternSingleChoice() {
        final List<String> rules = ImmutableList.of(
                "1: \"c\"",
                "2: \"d\"",
                "3: 1 | 2");
        final Map<Integer, Rule> ruleMap = Day19.parseRules(rules);
        final Rule rule = ruleMap.get(3);
        assertThat(rule.resolvePattern(ruleMap), is("(c|d)"));
    }

    @Test
    public void resolvePatternLetterRules() {
        final List<String> rules = ImmutableList.of(
                "1: \"c\"",
                "2: \"d\"",
                "3: 1 2 | 2 1");
        final Map<Integer, Rule> ruleMap = Day19.parseRules(rules);
        final Rule rule = ruleMap.get(3);
        assertThat(rule.resolvePattern(ruleMap), is("(cd|dc)"));
    }

    @Test
    public void resolvePatternWithNests() {
        final List<String> rules = ImmutableList.of(
                "1: \"c\"",
                "2: \"d\"",
                "3: 1 2",
                "4: 2 3",
                "5: 1 4 | 4 1");
        final Map<Integer, Rule> ruleMap = Day19.parseRules(rules);
        final Rule rule = ruleMap.get(5);
        assertThat(rule.resolvePattern(ruleMap), is("(cdcd|dcdc)"));
    }
}

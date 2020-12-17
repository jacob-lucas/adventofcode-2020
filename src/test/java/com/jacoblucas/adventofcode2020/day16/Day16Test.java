package com.jacoblucas.adventofcode2020.day16;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day16Test {
    private List<Rule> rules;

    @Before
    public void setUp() {
        rules = new ArrayList<>();
        rules.add(Rule.parse("class: 1-3 or 5-7").get());
        rules.add(Rule.parse("row: 6-11 or 33-44").get());
        rules.add(Rule.parse("seat: 13-40 or 45-50").get());
    }

    @Test
    public void t1() {
        final int valid = Day16.isValid("7,3,47", rules);
        assertThat(valid, is(0));
    }

    @Test
    public void t2() {
        final int valid = Day16.isValid("40,4,50", rules);
        assertThat(valid, is(4));
    }

    @Test
    public void t3() {
        final int valid = Day16.isValid("55,2,20", rules);
        assertThat(valid, is(55));
    }

    @Test
    public void t4() {
        final int valid = Day16.isValid("38,6,12", rules);
        assertThat(valid, is(12));
    }

    @Test
    public void testGetFields() {
        rules = new ArrayList<>();
        rules.add(Rule.parse("class: 0-1 or 4-19").get());
        rules.add(Rule.parse("row: 0-5 or 8-19").get());
        rules.add(Rule.parse("seat: 0-13 or 16-19").get());

        final List<String> tickets = ImmutableList.of(
                "3,9,18",
                "15,1,5",
                "5,14,9");

        final List<Pair<Rule, Integer>> fields = Day16.getFields(tickets, rules);
        assertThat(fields.stream()
                .map(Pair::getFirst)
                .map(Rule::getField)
                .collect(Collectors.toList()), is(ImmutableList.of("row", "class", "seat")));
    }
}

package com.jacoblucas.adventofcode2020.day7;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

public class Day7Test {
    private List<Rule> rules;

    @Before
    public void setUp() throws IOException {
        final List<String> input = InputReader.readFile("src/test/resources/", "day7-test-input.txt");
        rules = Day7.parseInput(input);
    }

    @Test
    public void testBagsContainingColoursUnknownColour() {
        assertThat(Day7.bagsContainingBagColour(rules, "unknown colour"), is(empty()));
    }

    @Test
    public void example1() {
        assertThat(Day7.bagsContainingBagColour(rules, "shiny gold"),
                containsInAnyOrder("bright white", "muted yellow", "dark orange", "light red"));
    }

    @Test
    public void example2() {
        assertThat(Day7.bagsContainingBagColour(rules, "dark olive"),
                containsInAnyOrder("shiny gold", "bright white", "muted yellow", "dark orange", "light red"));
    }

    @Test
    public void example3() {
        assertThat(Day7.bagsContainingBagColour(rules, "dark orange"), is(empty()));
    }
}

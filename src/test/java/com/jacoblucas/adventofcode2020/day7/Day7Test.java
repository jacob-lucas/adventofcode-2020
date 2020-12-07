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
    private static final String TEST_PATH = "src/test/resources/";

    private List<Rule> rulesP1;
    private List<Rule> rulesP2;

    @Before
    public void setUp() throws IOException {
        final List<String> inputP1 = InputReader.readFile(TEST_PATH, "day7-test-input-p1.txt");
        rulesP1 = Day7.parseInput(inputP1);
        final List<String> inputP2 = InputReader.readFile(TEST_PATH, "day7-test-input-p2.txt");
        rulesP2 = Day7.parseInput(inputP2);
    }

    @Test
    public void bagsContainingBagColoursUnknownColour() {
        assertThat(Day7.bagsContainingBagColour(rulesP1, "unknown colour"), is(empty()));
    }

    @Test
    public void bagsContainingBagColourExample1() {
        assertThat(Day7.bagsContainingBagColour(rulesP1, "shiny gold"),
                containsInAnyOrder("bright white", "muted yellow", "dark orange", "light red"));
    }

    @Test
    public void bagsContainingBagColourExample2() {
        assertThat(Day7.bagsContainingBagColour(rulesP1, "dark olive"),
                containsInAnyOrder("shiny gold", "bright white", "muted yellow", "dark orange", "light red"));
    }

    @Test
    public void bagsContainingBagColourExample3() {
        assertThat(Day7.bagsContainingBagColour(rulesP1, "dark orange"), is(empty()));
    }

    @Test
    public void bagsContainedByBagColourUnknownColour() {
        assertThat(Day7.bagsContainedByBagColour(rulesP2, "unknown colour"), is(0));
    }

    @Test
    public void bagsContainedByBagColourNoContents() {
        assertThat(Day7.bagsContainedByBagColour(rulesP2, "dark violet"), is(0));
    }

    @Test
    public void bagsContainedByBagColourPart1Rules() {
        assertThat(Day7.bagsContainedByBagColour(rulesP1, "shiny gold"), is(32));
    }

    @Test
    public void bagsContainedByBagColourPart2Rules() {
        assertThat(Day7.bagsContainedByBagColour(rulesP2, "shiny gold"), is(126));
    }
}

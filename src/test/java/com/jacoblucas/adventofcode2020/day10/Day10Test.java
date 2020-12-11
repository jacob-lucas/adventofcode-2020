package com.jacoblucas.adventofcode2020.day10;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day10Test {
    private List<JoltageAdapter> adapters;

    @Before
    public void setUp() throws IOException {
        adapters = Day10.parse(InputReader.readFile("src/test/resources/", "day10-test-input-p1.txt"));
    }

    @Test
    public void testChain() {
        final List<JoltageAdapter> chain = Day10.chain(adapters);

        final List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(10);
        expected.add(11);
        expected.add(12);
        expected.add(15);
        expected.add(16);
        expected.add(19);

        assertThat(chain.stream().map(JoltageAdapter::getOutput).collect(Collectors.toList()), is(expected));
    }

    @Test
    public void count1() {
        final List<JoltageAdapter> chain = Day10.outletToDevice(Day10.chain(adapters));
        final int n = Day10.countDifferences( chain, 1);
        assertThat(n, is(7));
    }

    @Test
    public void count3() {
        final List<JoltageAdapter> chain = Day10.outletToDevice(Day10.chain(adapters));
        final int n = Day10.countDifferences(chain, 3);
        assertThat(n, is(5));
    }

    @Test
    public void count1Example2() throws IOException {
        adapters = Day10.parse(InputReader.readFile("src/test/resources/", "day10-test-input-p1-2.txt"));
        final List<JoltageAdapter> chain = Day10.outletToDevice(Day10.chain(adapters));
        final int n = Day10.countDifferences(chain, 1);
        assertThat(n, is(22));
    }

    @Test
    public void count3Example2() throws IOException {
        adapters = Day10.parse(InputReader.readFile("src/test/resources/", "day10-test-input-p1-2.txt"));
        final List<JoltageAdapter> chain = Day10.outletToDevice(Day10.chain(adapters));
        final int n = Day10.countDifferences(chain, 3);
        assertThat(n, is(10));
    }

    @Test
    public void countCombinationsExample1() {
        final List<JoltageAdapter> chain = Day10.chain(adapters);
        final long combinations = Day10.countCombinations(chain);
        assertThat(combinations, is(8L));
    }

    @Test
    public void countCombinationsExample2() throws IOException {
        adapters = Day10.parse(InputReader.readFile("src/test/resources/", "day10-test-input-p1-2.txt"));
        final List<JoltageAdapter> chain = Day10.chain(adapters);
        final long combinations = Day10.countCombinations(chain);
        assertThat(combinations, is(19208L));
    }
}

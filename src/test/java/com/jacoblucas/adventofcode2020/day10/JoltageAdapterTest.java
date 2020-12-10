package com.jacoblucas.adventofcode2020.day10;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JoltageAdapterTest {
    private JoltageAdapter adapter;

    @Before
    public void setUp() {
        adapter = ImmutableJoltageAdapter.of(9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOutput() {
        ImmutableJoltageAdapter.of(-1);
    }

    @Test
    public void testIsValidInput() {
        assertThat(adapter.isValidInput(5), is(false));
        assertThat(adapter.isValidInput(6), is(true));
        assertThat(adapter.isValidInput(7), is(true));
        assertThat(adapter.isValidInput(8), is(true));
        assertThat(adapter.isValidInput(9), is(false));
        assertThat(adapter.isValidInput(10), is(false));
    }
}

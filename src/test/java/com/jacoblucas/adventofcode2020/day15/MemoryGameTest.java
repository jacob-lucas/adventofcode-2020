package com.jacoblucas.adventofcode2020.day15;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MemoryGameTest {
    @Test
    public void example0Intro() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(0,3,6));
        assertThat(game.get(4), is(0));
        assertThat(game.get(5), is(3));
        assertThat(game.get(6), is(3));
        assertThat(game.get(7), is(1));
        assertThat(game.get(8), is(0));
        assertThat(game.get(9), is(4));
        assertThat(game.get(10), is(0));
    }

    @Test
    public void example0() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(0,3,6));
        assertThat(game.get(2020), is(436));
    }

    @Test
    public void example1() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(1,3,2));
        assertThat(game.get(2020), is(1));
    }

    @Test
    public void example2() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(2,1,3));
        assertThat(game.get(2020), is(10));
    }

    @Test
    public void example3() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(1,2,3));
        assertThat(game.get(2020), is(27));
    }

    @Test
    public void example4() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(2,3,1));
        assertThat(game.get(2020), is(78));
    }

    @Test
    public void example5() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(3,2,1));
        assertThat(game.get(2020), is(438));
    }

    @Test
    public void example6() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(3,1,2));
        assertThat(game.get(2020), is(1836));
    }

    @Test
    public void example7() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(0,3,6));
        assertThat(game.get(30000000), is(175594));
    }

    @Test
    public void example8() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(1,3,2));
        assertThat(game.get(30000000), is(2578));
    }

    @Test
    public void example9() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(2,1,3));
        assertThat(game.get(30000000), is(3544142));
    }

    @Test
    public void example10() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(1,2,3));
        assertThat(game.get(30000000), is(261214));
    }

    @Test
    public void example11() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(2,3,1));
        assertThat(game.get(30000000), is(6895259));
    }

    @Test
    public void example12() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(3,2,1));
        assertThat(game.get(30000000), is(18));
    }

    @Test
    public void example13() {
        final MemoryGame game = new MemoryGame(ImmutableList.of(3,1,2));
        assertThat(game.get(30000000), is(362));
    }
}

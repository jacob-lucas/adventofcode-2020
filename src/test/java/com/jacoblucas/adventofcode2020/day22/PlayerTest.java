package com.jacoblucas.adventofcode2020.day22;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    @Test
    public void testParse() {
        final List<String> input = ImmutableList.of(
                "Player 1:",
                "9",
                "2",
                "6",
                "3",
                "1");

        final Player player = Player.parse(input);
        assertThat(player.getId(), is(1));

        final LinkedList<Integer> deck = new LinkedList<>(ImmutableList.of(9, 2, 6, 3, 1));
        assertThat(player.getDeck(), is(deck));
    }

    @Test
    public void testScore() {
        final Player player = new Player(2, new LinkedList<>(ImmutableList.of(
                3, 2, 10, 6, 8, 5, 9, 4, 7, 1)));

        assertThat(player.score(), is(306L));
    }
}

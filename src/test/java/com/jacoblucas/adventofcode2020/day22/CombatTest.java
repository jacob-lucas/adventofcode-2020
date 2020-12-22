package com.jacoblucas.adventofcode2020.day22;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CombatTest {
    private Player one;
    private Player two;
    private Combat combat;

    @Before
    public void setUp() {
        one = new Player(1, new LinkedList<>(ImmutableList.of(9,2,6,3,1)));
        two = new Player(2, new LinkedList<>(ImmutableList.of(5,8,4,7,10)));
        combat = new Combat(one, two);
    }

    @Test
    public void testGameOver() {
        while (!one.getDeck().isEmpty()) {
            assertThat(combat.gameOver(), is(false));
            one.getDeck().remove();
        }
        assertThat(combat.gameOver(), is(true));
    }

    @Test
    public void testPlayRound() {
        final AtomicInteger roundCount = new AtomicInteger(0);
        combat.playRound(roundCount);

        assertThat(roundCount.get(), is(1));
        assertThat(one.getDeck(), is(new LinkedList<>(ImmutableList.of(2,6,3,1,9,5))));
        assertThat(two.getDeck(), is(new LinkedList<>(ImmutableList.of(8,4,7,10))));
    }

    @Test
    public void testPlay() {
        final Player winner = combat.play();
        assertThat(winner.getId(), is(2));
    }
}

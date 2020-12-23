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
        combat = new Combat(one, two, false);
    }

    @Test
    public void testGameOverRegular() {
        while (!one.getDeck().isEmpty()) {
            assertThat(combat.gameOver(), is(false));
            one.getDeck().remove();
        }
        assertThat(combat.gameOver(), is(true));
        assertThat(combat.getWinner().getId(), is(2));
    }

    @Test
    public void testGameOverRecursive() {
        one = new Player(1, new LinkedList<>(ImmutableList.of(43, 19)));
        two = new Player(2, new LinkedList<>(ImmutableList.of(2, 29, 14)));
        combat = new Combat(one, two, true);

        combat.play();

        assertThat(combat.gameOver(), is(true));
        assertThat(combat.getWinner().getId(), is(1));
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
    public void testPlayRegular() {
        combat.play();
        assertThat(combat.getWinner().getId(), is(2));
        assertThat(combat.getWinner().score(), is(306L));
    }

    @Test
    public void testPlayRecursive() {
        combat = new Combat(one, two, true);
        combat.play();
        assertThat(combat.getWinner().getId(), is(2));
        assertThat(combat.getWinner().score(), is(291L));
    }
}

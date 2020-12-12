package com.jacoblucas.adventofcode2020.day12;

import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Day12Test {
    private Ship ship;
    private Waypoint waypoint;
    private List<Instruction> instructions;

    @Before
    public void setUp() {
        ship = new Ship();
        waypoint = new Waypoint(10, 1);
        instructions = Day12.toInstructions(ImmutableList.of("F10", "N3", "F7", "R90", "F11"));
    }

    @Test
    public void part1() {
        final int distance = Day12.moveShip(ship, instructions, null);
        assertThat(distance, is(25));
    }

    @Test
    public void part2() {
        final int distance = Day12.moveShip(ship, instructions, waypoint);
        assertThat(distance, is(286));
    }
}

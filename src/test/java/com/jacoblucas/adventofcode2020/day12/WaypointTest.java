package com.jacoblucas.adventofcode2020.day12;

import org.junit.Before;
import org.junit.Test;

import static com.jacoblucas.adventofcode2020.day12.Action.EAST;
import static com.jacoblucas.adventofcode2020.day12.Action.NORTH;
import static com.jacoblucas.adventofcode2020.day12.Action.RIGHT;
import static com.jacoblucas.adventofcode2020.day12.Action.SOUTH;
import static com.jacoblucas.adventofcode2020.day12.Action.WEST;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WaypointTest {
    private Waypoint waypoint;

    @Before
    public void setUp() {
        waypoint = new Waypoint(10, 1);
    }

    @Test
    public void testMoveWaypointNorth() {
        waypoint.move(ImmutableInstruction.of(NORTH, 3));
        assertThat(waypoint.getX(), is(10));
        assertThat(waypoint.getY(), is(4));
    }

    @Test
    public void testMoveWaypointSouth() {
        waypoint.move(ImmutableInstruction.of(SOUTH, 3));
        assertThat(waypoint.getX(), is(10));
        assertThat(waypoint.getY(), is(-2));
    }

    @Test
    public void testMoveWaypointWest() {
        waypoint.move(ImmutableInstruction.of(WEST, 5));
        assertThat(waypoint.getX(), is(5));
        assertThat(waypoint.getY(), is(1));
    }

    @Test
    public void testMoveWaypointEast() {
        waypoint.move(ImmutableInstruction.of(EAST, 10));
        assertThat(waypoint.getX(), is(20));
        assertThat(waypoint.getY(), is(1));
    }

    @Test
    public void testRotateWaypointRight90() {
        waypoint.move(ImmutableInstruction.of(RIGHT, 90));
        assertThat(waypoint.getX(), is(1));
        assertThat(waypoint.getY(), is(-10));
    }

    @Test
    public void testRotateWaypointRight270() {
        waypoint.move(ImmutableInstruction.of(RIGHT, 270));
        assertThat(waypoint.getX(), is(-1));
        assertThat(waypoint.getY(), is(10));
    }
}

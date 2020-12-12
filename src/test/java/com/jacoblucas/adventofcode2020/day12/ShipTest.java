package com.jacoblucas.adventofcode2020.day12;

import org.junit.Before;
import org.junit.Test;

import static com.jacoblucas.adventofcode2020.day12.Action.EAST;
import static com.jacoblucas.adventofcode2020.day12.Action.FORWARD;
import static com.jacoblucas.adventofcode2020.day12.Action.LEFT;
import static com.jacoblucas.adventofcode2020.day12.Action.NORTH;
import static com.jacoblucas.adventofcode2020.day12.Action.SOUTH;
import static com.jacoblucas.adventofcode2020.day12.Action.WEST;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShipTest {
    private Ship ship;
    private Waypoint waypoint;

    @Before
    public void setUp() {
        ship = new Ship();
        waypoint = new Waypoint(10, 1);
    }

    @Test
    public void testMoveForward() {
        ship.move(ImmutableInstruction.of(FORWARD, 5));
        assertThat(ship.getX(), is(5));
        assertThat(ship.getY(), is(0));
    }

    @Test
    public void testMoveNorth() {
        ship.move(ImmutableInstruction.of(NORTH, 5));
        assertThat(ship.getX(), is(0));
        assertThat(ship.getY(), is(5));
    }

    @Test
    public void testMoveSouth() {
        ship.move(ImmutableInstruction.of(SOUTH, 5));
        assertThat(ship.getX(), is(0));
        assertThat(ship.getY(), is(-5));
    }

    @Test
    public void testMoveWest() {
        ship.move(ImmutableInstruction.of(WEST, 5));
        assertThat(ship.getX(), is(-5));
        assertThat(ship.getY(), is(0));
    }

    @Test
    public void testMoveEast() {
        ship.move(ImmutableInstruction.of(EAST, 5));
        assertThat(ship.getX(), is(5));
        assertThat(ship.getY(), is(0));
    }

    @Test
    public void testLeft90() {
        final int x = ship.getX();
        final int y = ship.getY();
        ship.move(ImmutableInstruction.of(LEFT, 90));
        assertThat(ship.getX(), is(x));
        assertThat(ship.getY(), is(y));
        assertThat(ship.getDirection(), is(NORTH.ch));
    }

    @Test
    public void testLeft270() {
        final int x = ship.getX();
        final int y = ship.getY();
        ship.move(ImmutableInstruction.of(LEFT, 270));
        assertThat(ship.getX(), is(x));
        assertThat(ship.getY(), is(y));
        assertThat(ship.getDirection(), is(SOUTH.ch));
    }

    @Test
    public void testMoveForwardWithWaypoint() {
        ship.move(ImmutableInstruction.of(FORWARD, 10), waypoint);
        assertThat(ship.getX(), is(100));
        assertThat(ship.getY(), is(10));
        assertThat(waypoint.getX(), is(10));
        assertThat(waypoint.getY(), is(1));
    }
}

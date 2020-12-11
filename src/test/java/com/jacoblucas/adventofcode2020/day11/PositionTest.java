package com.jacoblucas.adventofcode2020.day11;

import org.junit.Test;

import static com.jacoblucas.adventofcode2020.day11.Position.EMPTY;
import static com.jacoblucas.adventofcode2020.day11.Position.FLOOR;
import static com.jacoblucas.adventofcode2020.day11.Position.OCCUPIED;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PositionTest {
    @Test
    public void ofValid() {
        assertThat(Position.of("."), is(FLOOR));
        assertThat(Position.of("L"), is(EMPTY));
        assertThat(Position.of("#"), is(OCCUPIED));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ofInvalid() {
        Position.of("x");
    }
}

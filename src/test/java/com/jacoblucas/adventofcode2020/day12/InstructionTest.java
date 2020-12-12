package com.jacoblucas.adventofcode2020.day12;

import org.junit.Test;

import static com.jacoblucas.adventofcode2020.day12.Action.EAST;
import static com.jacoblucas.adventofcode2020.day12.Action.FORWARD;
import static com.jacoblucas.adventofcode2020.day12.Action.NORTH;
import static com.jacoblucas.adventofcode2020.day12.Action.RIGHT;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InstructionTest {
    @Test
    public void testParse() {
        assertThat(Instruction.parse("F10").get(), is(ImmutableInstruction.of(FORWARD, 10)));
        assertThat(Instruction.parse("N3").get(), is(ImmutableInstruction.of(NORTH, 3)));
        assertThat(Instruction.parse("R90").get(), is(ImmutableInstruction.of(RIGHT, 90)));
        assertThat(Instruction.parse("E5").get(), is(ImmutableInstruction.of(EAST, 5)));
    }
}

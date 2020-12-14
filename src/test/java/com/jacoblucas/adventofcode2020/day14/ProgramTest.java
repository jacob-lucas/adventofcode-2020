package com.jacoblucas.adventofcode2020.day14;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProgramTest {
    @Test
    public void testToBinaryString() {
        assertThat(Program.toBinaryString(11), is("000000000000000000000000000000001011"));
        assertThat(Program.toBinaryString(101), is("000000000000000000000000000001100101"));
    }

    @Test
    public void testParse() {
        final List<String> input = ImmutableList.of(
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0");

        final Program program = Program.parse(input);
        assertThat(program.getInstructions(), is(ImmutableList.of(
                ImmutableBitmaskInstruction.of("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"),
                ImmutableMemoryInstruction.of(8, 11),
                ImmutableMemoryInstruction.of(7, 101),
                ImmutableMemoryInstruction.of(8, 0))));
    }

    @Test
    public void testWriteExample1() {
        final Program program = new Program();
        program.setBitmask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        program.write(8, 11);
        assertThat(program.read(8), is(Optional.of(73)));
    }

    @Test
    public void testWriteExample2() {
        final Program program = new Program();
        program.setBitmask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        program.write(8, 11);
        program.write(7, 101);
        assertThat(program.read(7), is(Optional.of(101)));
    }

    @Test
    public void testWriteExample3() {
        final Program program = new Program();
        program.setBitmask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        program.write(8, 11);
        program.write(7, 101);
        program.write(8, 0);
        assertThat(program.read(8), is(Optional.of(64)));
    }

    @Test
    public void testExecute() {
        final List<String> input = ImmutableList.of(
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0");

        final Program program = Program.parse(input);

        program.execute();

        assertThat(program.read(7).get(), is(101L));
        assertThat(program.read(8).get(), is(64L));
    }
}

package com.jacoblucas.adventofcode2020.day8;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import com.jacoblucas.adventofcode2020.utils.Pair;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameConsoleTest {
    private static final String TEST_PATH = "src/test/resources/";

    @Test
    public void testBootFailure() throws IOException {
        final List<String> lines = InputReader.readFile(TEST_PATH, "day8-test-input1.txt");
        final Instruction[] instructions = Day8.toInstructions(lines);

        final GameConsole gameConsole = new GameConsole(instructions);
        final Pair<Integer, Boolean> output = gameConsole.boot();

        assertThat(output.getFirst(), is(5));
        assertThat(output.getSecond(), is(false));
    }

    @Test
    public void testBootSuccess() throws IOException {
        final List<String> lines = InputReader.readFile(TEST_PATH, "day8-test-input1.txt");
        final Instruction[] instructions = Day8.toInstructions(ImmutableList.of(
                "nop +0",
                "acc +1",
                "nop +0",
                "acc +2"
        ));

        final GameConsole gameConsole = new GameConsole(instructions);
        final Pair<Integer, Boolean> output = gameConsole.boot();

        assertThat(output.getFirst(), is(3));
        assertThat(output.getSecond(), is(true));
    }
}

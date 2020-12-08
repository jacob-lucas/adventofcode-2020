package com.jacoblucas.adventofcode2020.day8;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameConsoleTest {
    private static final String TEST_PATH = "src/test/resources/";

    @Test
    public void testBoot() throws IOException {
        final List<String> lines = InputReader.readFile(TEST_PATH, "day8-test-input1.txt");
        final Instruction[] instructions = Day8.toInstructions(lines);

        final GameConsole gameConsole = new GameConsole(instructions);
        final int output = gameConsole.boot();

        assertThat(output, is(5));
    }
}

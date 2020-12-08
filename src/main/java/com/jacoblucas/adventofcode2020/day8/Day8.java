package com.jacoblucas.adventofcode2020.day8;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day8-input.txt");
        final Instruction[] instructions = toInstructions(lines);

        final GameConsole gameConsole = new GameConsole(instructions);
        final int output = gameConsole.boot();
        System.out.println(output);
    }

    public static Instruction[] toInstructions(final List<String> lines) {
        return lines.stream()
                .map(Instruction::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList())
                .toArray(new Instruction[]{});
    }
}

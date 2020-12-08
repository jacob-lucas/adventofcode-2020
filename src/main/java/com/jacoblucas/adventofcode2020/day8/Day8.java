package com.jacoblucas.adventofcode2020.day8;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import com.jacoblucas.adventofcode2020.utils.Pair;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.jacoblucas.adventofcode2020.day8.Operation.JMP;
import static com.jacoblucas.adventofcode2020.day8.Operation.NOP;

public class Day8 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day8-input.txt");
        final Instruction[] instructions = toInstructions(lines);

        final GameConsole gameConsole = new GameConsole(instructions);
        final Pair<Integer, Boolean> output1 = gameConsole.boot();
        System.out.println(output1.getFirst());

        // NOP => JMP
        Pair<Integer, Boolean> flip = flip(lines, NOP, JMP);
        if (flip != null) {
            System.out.println(flip.getFirst());
        }

        // JMP => NOP
        flip = flip(lines, JMP, NOP);
        if (flip != null) {
            System.out.println(flip.getFirst());
        }
    }

    public static Instruction[] toInstructions(final List<String> lines) {
        return lines.stream()
                .map(Instruction::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList())
                .toArray(new Instruction[]{});
    }

    private static Pair<Integer, Boolean> flip(final List<String> lines, final Operation from, final Operation to) {
        final Instruction[] instructions = toInstructions(lines);
        for (int i=0; i<instructions.length; i++) {
            final Instruction instruction = instructions[i];
            if (instruction.getOperation() == from) {
                // flip and test
                final Instruction[] flipped = toInstructions(lines);
                flipped[i] = ImmutableInstruction.copyOf(instruction).withOperation(to);
                final Pair<Integer, Boolean> output = new GameConsole(flipped).boot();
                if (output.getSecond()) {
                    return output;
                }
            }
        }
        return null;
    }
}

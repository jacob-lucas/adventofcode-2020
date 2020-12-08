package com.jacoblucas.adventofcode2020.day8;

import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.Pair;

import java.util.HashSet;
import java.util.Set;

import static com.jacoblucas.adventofcode2020.day8.Operation.ACC;
import static com.jacoblucas.adventofcode2020.day8.Operation.JMP;
import static com.jacoblucas.adventofcode2020.day8.Operation.NOP;

public class GameConsole {
    private final Instruction[] instructions;

    private int accumulator;

    public GameConsole(final Instruction[] instructions) {
        this.instructions = instructions;
        accumulator = 0;
    }

    public Pair<Integer, Boolean> boot() {
        final Set<Integer> loopDetector = new HashSet<>();
        int pos = 0;
        boolean booted = false;

        while (!booted && !loopDetector.contains(pos)) {
            final int n = pos;
            loopDetector.add(n);

            final Instruction instruction = instructions[n];
            final Operation operation = instruction.getOperation();
            if (operation == NOP) {
                pos++;
            } else if (operation == ACC) {
                accumulator += instruction.getArgument();
                pos++;
            } else if (operation == JMP) {
                pos += instruction.getArgument();
            }

            // System.out.println("[pos=" + n + "] " + instruction + " => accumulator=" + accumulator);
            if (pos >= instructions.length) {
                booted = true;
            }
        }

        return ImmutablePair.of(accumulator, booted);
    }
}

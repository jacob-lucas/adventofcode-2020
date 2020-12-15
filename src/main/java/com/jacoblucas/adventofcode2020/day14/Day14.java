package com.jacoblucas.adventofcode2020.day14;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class Day14 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day14-input.txt");

        final Program program = Program.parse(lines);
        program.execute();
        System.out.println(sum(program.getMemory().values()));

        final Program programV2 = Program.parse(lines);
        programV2.setVersion(2);
        programV2.execute();
        System.out.println(sum(programV2.getMemory().values()));
    }

    private static long sum(final Collection<Long> longs) {
        return longs.stream().reduce(0L, Long::sum);
    }
}

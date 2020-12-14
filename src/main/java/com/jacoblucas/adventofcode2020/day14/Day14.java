package com.jacoblucas.adventofcode2020.day14;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day14 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day14-input.txt");
        final Program program = Program.parse(lines);

        program.execute();

        System.out.println(program.getMemory().values().stream().reduce(0L, Long::sum));
    }
}

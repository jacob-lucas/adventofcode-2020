package com.jacoblucas.adventofcode2020.day12;

import com.jacoblucas.adventofcode2020.utils.Calculator;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day12 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day12-input.txt");
        final List<Instruction> instructions = lines.stream()
                .map(Instruction::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList());

        final Ship ship = new Ship();
        instructions.forEach(ship::move);

        final int distance = Calculator.manhattanDistance(0, 0, ship.getX(), ship.getY());
        System.out.println(distance);
    }
}

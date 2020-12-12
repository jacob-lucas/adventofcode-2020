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
        final List<Instruction> instructions = toInstructions(lines);

        // part 1
        moveShip(new Ship(), instructions, null);

        // part 2
        moveShip(new Ship(), instructions, new Waypoint(10, 1));
    }

    static List<Instruction> toInstructions(List<String> lines) {
        return lines.stream()
                .map(Instruction::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList());
    }

    public static int moveShip(final Ship ship, final List<Instruction> instructions, final Waypoint waypoint) {
        if (waypoint == null) {
            instructions.forEach(ship::move);
        } else {
            instructions.forEach(i -> ship.move(i, waypoint));
        }
        return distanceFromOrigin(ship);
    }

    private static int distanceFromOrigin(final Ship ship) {
        final int distance = Calculator.manhattanDistance(0, 0, ship.getX(), ship.getY());
        System.out.println(distance);
        return distance;
    }
}

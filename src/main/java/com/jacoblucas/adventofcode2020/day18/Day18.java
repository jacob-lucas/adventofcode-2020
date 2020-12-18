package com.jacoblucas.adventofcode2020.day18;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day18 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day18-input.txt");

        final long expressionSum = lines.stream()
                .map(Expression::new)
                .mapToLong(Expression::evaluate)
                .sum();
        System.out.println(expressionSum);
    }
}

package com.jacoblucas.adventofcode2020.day18;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;

public class Day18 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day18-input.txt");

        final Evaluator inOrderEvaluator = new InOrderEvaluator();
        long expressionSum = lines.stream()
                .mapToLong(inOrderEvaluator::evaluate)
                .sum();
        System.out.println(expressionSum);

        final Evaluator addFirstEvaluator = new AddFirstEvaluator();
        expressionSum = lines.stream()
                .mapToLong(addFirstEvaluator::evaluate)
                .sum();
        System.out.println(expressionSum);
    }
}

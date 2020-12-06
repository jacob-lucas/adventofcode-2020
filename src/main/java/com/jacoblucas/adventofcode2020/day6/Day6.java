package com.jacoblucas.adventofcode2020.day6;

import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) throws IOException {
        final List<List<String>> groups = InputReader.readGroups("day6-input.txt");

        final int questionCountSum = getQuestionCountSum(groups);
        System.out.println(questionCountSum);
    }

    public static String uniqueQuestions(final List<String> group) {
        final Set<String> uniques = String.join("", group)
                .chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.toSet());
        return String.join("", uniques);
    }

    public static int getQuestionCountSum(final List<List<String>> groups) {
        return groups.stream()
                .map(Day6::uniqueQuestions)
                .mapToInt(String::length)
                .sum();
    }
}

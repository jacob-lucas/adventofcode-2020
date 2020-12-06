package com.jacoblucas.adventofcode2020.day6;

import com.google.common.collect.Sets;
import com.jacoblucas.adventofcode2020.utils.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) throws IOException {
        final List<List<String>> groups = InputReader.readGroups("day6-input.txt");

        final int uniqueQuestionCountSum = getQuestionCountSum(groups, Day6::uniqueQuestions);
        System.out.println(uniqueQuestionCountSum);

        final int commonQuestionCountSum = getQuestionCountSum(groups, Day6::commonQuestions);
        System.out.println(commonQuestionCountSum);
    }

    public static String uniqueQuestions(final List<String> group) {
        final Set<String> uniques = toSet(String.join("", group));
        return String.join("", uniques);
    }

    public static String commonQuestions(final List<String> groups) {
        final String allQuestions = "abcdefghijklmnopqrstuvwxyz";
        final Set<String> commons = groups.stream()
                .map(Day6::toSet)
                .reduce(toSet(allQuestions), Sets::intersection);

        return String.join("", commons);
    }

    public static int getQuestionCountSum(final List<List<String>> groups, final Function<List<String>, String> questionAnalyser) {
        return groups.stream()
                .map(questionAnalyser)
                .mapToInt(String::length)
                .sum();
    }

    private static Set<String> toSet(final String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.toSet());
    }
}

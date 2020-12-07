package com.jacoblucas.adventofcode2020.day7;

import com.google.common.collect.Sets;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day7 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day7-input.txt");

        final List<Rule> rules = parseInput(lines);
        final Set<String> bags = bagsContainingBagColour(rules, "shiny gold");
        System.out.println(bags.size());
    }

    public static List<Rule> parseInput(final List<String> input) {
        return input.stream()
                .map(Rule::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList());
    }

    public static Set<String> bagsContainingBagColour(final List<Rule> rules, final String colour) {
        final Set<String> bagsDirectlyContainingColour = rules.stream()
                .filter(r -> r.getContentsByColour().containsKey(colour))
                .map(Rule::getColour)
                .collect(Collectors.toSet());

        return Sets.union(bagsDirectlyContainingColour, bagsDirectlyContainingColour.stream()
                .map(bag -> bagsContainingBagColour(rules, bag))
                .flatMap(Set::stream)
                .collect(Collectors.toSet()));
    }
}

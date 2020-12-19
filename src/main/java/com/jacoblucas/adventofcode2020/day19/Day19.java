package com.jacoblucas.adventofcode2020.day19;

import com.google.common.collect.Maps;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day19 {
    static final Pattern RULE_PATTERN = Pattern.compile("^\\d{1,3}:.*");

    public static void main(String[] args) throws IOException {
        final List<String> input = InputReader.read("day19-input.txt");

        final Map<Integer, Rule> rules = parseRules(input);

        final List<String> messages = input.stream()
                .filter(str -> !str.isEmpty() && !RULE_PATTERN.matcher(str).matches())
                .collect(Collectors.toList());

        final MessageValidator validator = new MessageValidator(rules);
        final List<String> matches = validator.match(0, messages);
        System.out.println(matches.size());
    }

    public static Map<Integer, Rule> parseRules(final List<String> input) {
        return Maps.uniqueIndex(input.stream()
                .filter(str -> RULE_PATTERN.matcher(str).matches())
                .map(Rule::parse)
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList()), Rule::getId);
    }
}

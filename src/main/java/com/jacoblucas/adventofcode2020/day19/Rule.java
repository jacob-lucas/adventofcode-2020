package com.jacoblucas.adventofcode2020.day19;

import io.vavr.control.Try;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Rule {
    public abstract int getId();

    public abstract String resolvePattern(final Map<Integer, Rule> ruleMap);

    public static Try<Rule> parse(final String str) {
        return Try.of(() -> {
            final String[] parts = str.split(":");
            final int id = Integer.parseInt(parts[0]);
            final String ruleStr = parts[1].trim();
            final String[] ruleParts = ruleStr.split(" ");
            if (ruleStr.contains("|")) {
                final String[] choices = ruleStr.split(" \\| ");
                return ImmutableChoiceRule.builder()
                        .id(id)
                        .addAllChoices(Arrays.stream(choices)
                                .map(ids -> Arrays.stream(ids.split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList()))
                                .collect(Collectors.toList()))
                        .build();
            } else if (ruleStr.contains("\"")) {
                return ImmutableLetterRule.builder()
                        .id(id)
                        .letter(ruleStr.charAt(1))
                        .build();
            } else {
                return ImmutableListRule.builder()
                        .id(id)
                        .addAllRuleIds(Arrays.stream(ruleParts)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()))
                        .build();
            }
        });
    }
}

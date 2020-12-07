package com.jacoblucas.adventofcode2020.day7;

import io.vavr.control.Try;
import org.immutables.value.Value;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Value.Immutable
public abstract class Rule {
    public abstract String getColour();

    public abstract Map<String, Integer> getContentsByColour();

    // e.g. light red bags contain 1 bright white bag, 2 muted yellow bags.
    public static Try<Rule> parse(final String rule) {
        return Try.of(() -> {
            final String[] ruleParts = rule.split(" contain ");

            final String colour = ruleParts[0].substring(0, ruleParts[0].length() - 5);
            final String[] contents = Arrays.stream(ruleParts[1].split(","))
                    .map(String::trim)
                    .collect(Collectors.toList())
                    .toArray(new String[]{});

            final ImmutableRule.Builder builder = ImmutableRule.builder()
                    .colour(colour);

            if (contents[0].equals("no other bags.")) {
                return builder.build();
            } else {
                final Map<String, Integer> contentsByColour = Arrays.stream(contents)
                        .map(str -> str.split(" "))
                        .collect(Collectors.toMap(
                                parts -> parts[1] + " " + parts[2],
                                parts -> Integer.valueOf(parts[0].trim())));
                return builder
                        .contentsByColour(contentsByColour)
                        .build();
            }
        });
    }
}

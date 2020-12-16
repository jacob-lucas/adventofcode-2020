package com.jacoblucas.adventofcode2020.day16;

import com.google.common.collect.ImmutableList;
import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.Pair;
import io.vavr.control.Try;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public abstract class Rule {
    public abstract String getField();

    public abstract List<Pair<Integer, Integer>> getValidRanges();

    public boolean isValid(final int input) {
        return getValidRanges().stream()
                .anyMatch(r -> input >= r.getFirst() && input <= r.getSecond());
    }

    // name: a-b or c-d
    public static Try<Rule> parse(String str) {
        return Try.of(() -> {
            final String[] parts = str.split(" ");
            return ImmutableRule.builder()
                    .field(parts[0].substring(0, parts[0].length() - 1))
                    .validRanges(ImmutableList.of(
                            parseRange(parts[1]),
                            parseRange(parts[3])))
                    .build();
        });
    }

    private static Pair<Integer, Integer> parseRange(final String str) {
        final String[] rangeParts = str.split("-");
        return ImmutablePair.of(
                Integer.parseInt(rangeParts[0]),
                Integer.parseInt(rangeParts[1]));
    }
}

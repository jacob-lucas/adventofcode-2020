package com.jacoblucas.adventofcode2020.day2;

import com.jacoblucas.adventofcode2020.utils.ImmutablePair;
import com.jacoblucas.adventofcode2020.utils.InputReader;
import com.jacoblucas.adventofcode2020.utils.Pair;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day2-input.txt");

        final List<Pair<PasswordPolicy, String>> passwords = lines.stream()
                .map(Day2::parse)
                .collect(Collectors.toList());

        long validCountV1 = countValid(passwords, new PasswordValidatorV1());
        System.out.println(validCountV1);

        long validCountV2 = countValid(passwords, new PasswordValidatorV2());
        System.out.println(validCountV2);
    }

    // <min>-<max> <letter>: <password>
    public static Pair<PasswordPolicy, String> parse(final String line) {
        try {
            final String[] parts = line.split(" ");
            final String password = parts[2];

            final String[] bounds = parts[0].split("-");
            final int min = Integer.parseInt(bounds[0]);
            final int max = Integer.parseInt(bounds[1]);

            final char letter = parts[1].charAt(0);
            return ImmutablePair.of(
                    ImmutablePasswordPolicy.builder()
                            .minimum(min)
                            .maximum(max)
                            .letter(letter)
                            .build(),
                    password);
        } catch (final Exception e) {
            throw new IllegalArgumentException("Invalid password input: " + line);
        }
    }

    public static long countValid(final List<Pair<PasswordPolicy, String>> passwords, final PasswordValidator validator) {
        return passwords.stream()
                .filter(pair -> validator.isValid(pair.getSecond(), pair.getFirst()))
                .count();
    }
}

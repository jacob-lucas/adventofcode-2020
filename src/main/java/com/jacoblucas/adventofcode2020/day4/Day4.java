package com.jacoblucas.adventofcode2020.day4;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) throws IOException {
        final List<String> lines = InputReader.read("day4-input.txt");

        final List<Passport> validPassports = parse(lines);

        System.out.println(validPassports.size());

        final List<Passport> validValuePassports = validPassports.stream()
                .filter(p -> Try.run(p::validate).isSuccess())
                .collect(Collectors.toList());

        System.out.println(validValuePassports.size());
    }

    public static List<Passport> parse(final List<String> input) {
        final List<Passport> validPassports = new ArrayList<>();
        int startIdx = 0;
        for (int i=0; i<input.size(); i++) {
            final String line = input.get(i);
            if (line.isEmpty()) {
                final List<String> inputLines = input.subList(startIdx, i);
                System.out.println(inputLines);
                final Try<Passport> passport = Try.of(() -> Passport.parse(inputLines));
                if (passport.isSuccess()) {
                    validPassports.add(passport.get());
                } else {
                    System.out.println(inputLines + " is invalid! " + passport.failed().get());
                }
                startIdx = i + 1;
            }
        }

        return validPassports;
    }
}

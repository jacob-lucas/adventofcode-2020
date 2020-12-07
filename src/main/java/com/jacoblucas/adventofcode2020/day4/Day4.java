package com.jacoblucas.adventofcode2020.day4;

import com.jacoblucas.adventofcode2020.utils.InputReader;
import io.vavr.control.Try;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) throws IOException {
        final List<List<String>> groups = InputReader.readGroups("day4-input.txt");

        final List<Passport> validPassports = parse(groups);
        System.out.println(validPassports.size());

        final List<Passport> validValuePassports = validPassports.stream()
                .filter(p -> Try.run(p::validate).isSuccess())
                .collect(Collectors.toList());
        System.out.println(validValuePassports.size());
    }

    public static List<Passport> parse(final List<List<String>> input) {
        return input.stream()
                .map(grp -> {
                    System.out.println(grp);
                    final Try<Passport> passport = Try.of(() -> Passport.parse(grp));
                    if (!passport.isSuccess()) {
                        System.out.println(grp + " is invalid! " + passport.failed().get());
                    }
                    return passport;
                })
                .filter(Try::isSuccess)
                .map(Try::get)
                .collect(Collectors.toList());
    }
}
